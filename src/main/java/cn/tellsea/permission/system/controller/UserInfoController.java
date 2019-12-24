package cn.tellsea.permission.system.controller;

import cn.tellsea.permission.system.service.UserInfoService;
import cn.tellsea.permission.system.vo.UserInfoVo;
import cn.tellsea.walnut.base.controller.BaseController;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.plugins.element.ElementTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("userInfo")
public class UserInfoController extends BaseController<UserInfoService> {

    @ApiOperation(value = "表格数据")
    @PostMapping("list")
    public ElementTable list(UserInfoVo userInfoVo) {
        return baseService.listUserInfo(userInfoVo);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("save")
    public ResponseResult save(UserInfoVo userInfoVo) {
        return baseService.saveUserInfo(userInfoVo);
    }

    @ApiOperation(value = "更新用户")
    @PostMapping("update")
    public ResponseResult update(UserInfoVo userInfoVo) {
        return baseService.updateUserInfo(userInfoVo);
    }

    @ApiOperation(value = "根据id查询用户")
    @PostMapping("getById")
    public ResponseResult getById(UserInfoVo userInfoVo) {
        return baseService.getUserInfoById(userInfoVo);
    }

    @ApiOperation(value = "根据id删除用户")
    @PostMapping("delete")
    public ResponseResult delete(UserInfoVo userInfoVo) {
        return baseService.deleteUserInfo(userInfoVo);
    }
}
