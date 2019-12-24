package cn.tellsea.permission.login.controller;

import cn.tellsea.permission.system.entity.UserInfo;
import cn.tellsea.permission.system.service.ResourceInfoService;
import cn.tellsea.permission.system.service.RoleInfoService;
import cn.tellsea.permission.system.service.UserInfoService;
import cn.tellsea.permission.system.vo.ResourceInfoVo;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.aop.annotation.LoginLog;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.dto.UserInfoSession;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.util.JwtTokenUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录控制器
 *
 * @author Tellsea
 * @date 2019/12/22
 */
@Slf4j
@Api(tags = "登录控制器")
@RestController
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private ResourceInfoService resourceInfoService;

    @LoginLog
    @PostMapping("login")
    @ApiOperation(value = "登录")
    public ResponseResult login(UserInfoVo userInfoVo) {
        UsernamePasswordToken token = new UsernamePasswordToken(userInfoVo.getUserName(), userInfoVo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userInfoVo.getUserName());
            UserInfo user = userInfoService.selectOne(userInfo);
            List<String> roleInfoList = roleInfoService.listRoleInfoByUserId(user.getId());
            List<String> resourceInfoList = resourceInfoService.listResourceInfoByUserId(user.getId());
            List<ResourceInfoVo> menuList = resourceInfoService.listResourceInfoByMenu(user.getId());
            UserInfoSession ui = new UserInfoSession();
            BeanUtils.copyProperties(user, ui);
            ui.setRoleInfoList(roleInfoList);
            ui.setResourceInfoList(resourceInfoList);
            ui.setPassword("");
            ui.setSalt("");
            Map<String, Object> map = new HashMap<>(16);
            map.put("user", ui);
            map.put("token", JwtTokenUtils.sign(userInfoVo.getUserName()));
            map.put("menuList", menuList);
            return ResponseResult.build(StatusEnums.LOGIN_SUCCESS, map);
        } catch (DisabledAccountException e) {
            return ResponseResult.build(StatusEnums.LOCKED_ACCOUNT_ERROR, userInfoVo.getUserName());
        } catch (UnknownAccountException e) {
            return ResponseResult.build(StatusEnums.USER_NOT_FOUND, userInfoVo.getUserName());
        } catch (IncorrectCredentialsException e) {
            return ResponseResult.build(StatusEnums.PASSWORD_ERROR, userInfoVo.getUserName());
        }
    }

    @GetMapping("unauth")
    @ApiOperation(value = "未登录")
    public ResponseResult unauth() {
        return ResponseResult.build(StatusEnums.NOT_LOGIN);
    }

    @PostMapping("createMenu")
    @ApiOperation(value = "测试请求头")
    public ResponseResult createMenu(@RequestHeader Map<String,Object> header, Integer userId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(header));
        return ResponseResult.build(StatusEnums.OK);
    }
}
