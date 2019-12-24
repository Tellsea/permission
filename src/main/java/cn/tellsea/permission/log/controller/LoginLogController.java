package cn.tellsea.permission.log.controller;

import cn.tellsea.permission.log.service.LoginLogService;
import cn.tellsea.permission.log.vo.LoginLogVo;
import cn.tellsea.walnut.base.controller.BaseController;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.plugins.element.ElementTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "登录日志表")
@RestController
@RequestMapping("loginLog")
public class LoginLogController extends BaseController<LoginLogService> {

    @ApiOperation(value = "数据表格")
    @PostMapping("list")
    public ElementTable list(LoginLogVo loginLogVo) {
        return baseService.listLoginLog(loginLogVo);
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("delete")
    public ResponseResult delete(LoginLogVo loginLogVo) {
        baseService.deleteByPrimaryKey(loginLogVo.getId());
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }

    @ApiOperation(value = "根据多个id删除")
    @PostMapping("deleteByIds")
    public ResponseResult deleteByIds(LoginLogVo loginLogVo) {
        baseService.deleteByIds(loginLogVo.getIds());
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }
}
