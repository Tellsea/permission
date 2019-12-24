package cn.tellsea.walnut.aop.aspect;

import cn.tellsea.permission.log.entity.LoginLog;
import cn.tellsea.permission.log.service.LoginLogService;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.global.exception.GlobalException;
import cn.tellsea.walnut.util.AddressUtils;
import cn.tellsea.walnut.util.IpUtils;
import cn.tellsea.walnut.util.SpringContextUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录日志切面
 *
 * @author Tellsea
 * @date 2019/7/18
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings("all")
public class LoginLogAspect {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 登录日志切点
     */
    @Pointcut("@annotation(cn.tellsea.walnut.aop.annotation.LoginLog)")
    public void loginLogAspect() {
    }

    @Around("loginLogAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException {
        Object result = null;
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        LoginLog loginLog = new LoginLog();
        loginLog.setCreateTime(new Date());
        Map<String, Object> fieldsName = getFieldsName(proceedingJoinPoint);
        fieldsName.entrySet().forEach(temp -> {
            if (StringUtils.equals("userName", temp.getKey())) {
                // todo 用户id
                // loginLog.setUserName(temp.getValue().toString());
            }
        });
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("环绕切入异常");
            throw new GlobalException(StatusEnums.SERVER_ERROR);
        }
        String ip = IpUtils.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtils.getAddress(ip));
        ResponseResult rr = (ResponseResult) result;
        loginLog.setCode(rr.getCode());
        loginLog.setMessage(rr.getMessage());
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        loginLog.setDevice(browser.getName() + " -- " + operatingSystem.getName());
        loginLogService.insertSelective(loginLog);

        return result;
    }

    /**
     * 获取参数列表
     *
     * @param proceedingJoinPoint
     * @return
     */
    private static Map<String, Object> getFieldsName(ProceedingJoinPoint proceedingJoinPoint) {
        // 参数值
        Object[] args = proceedingJoinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);
        Map<String, Object> paramMap = new HashMap<>(32);
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }
}
