package cn.tellsea.walnut.shiro.filter;

import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.util.JwtTokenUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token 验证器
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@Slf4j
public class JwtTokenCheckFilter extends AccessControlFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        if (StringUtils.equals(req.getMethod(), "OPTIONS")) {
            rep.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        rep.setCharacterEncoding("utf-8");
        rep.setContentType("application/json; charset=utf-8");
        String token = req.getHeader("token");
        log.info("JwtTokenCheckFilter：Token：{}", token);
        if (StringUtils.isNotEmpty(token)) {
            boolean result = JwtTokenUtils.verify(token);
            if (result) {
                log.info("JwtTokenCheckFilter：Token验证通过");
                return true;
            }
        }
        rep.getWriter().append(JSON.toJSONString(ResponseResult.build(StatusEnums.TOKEN_NOT_FOUND)));
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }
}
