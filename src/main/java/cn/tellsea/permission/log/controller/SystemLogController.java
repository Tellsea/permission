package cn.tellsea.permission.log.controller;

import cn.tellsea.permission.log.service.SystemLogService;
import cn.tellsea.permission.log.vo.SystemLogVo;
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
 * 系统日志表 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "系统日志表")
@RestController
@RequestMapping("systemLog")
public class SystemLogController extends BaseController<SystemLogService> {

    @ApiOperation(value = "数据表格")
    @PostMapping("list")
    public ElementTable list(SystemLogVo systemLogVo) {
        return baseService.listSystemLog(systemLogVo);
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("delete")
    public ResponseResult delete(SystemLogVo systemLogVo) {
        baseService.deleteByPrimaryKey(systemLogVo.getId());
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }

    @ApiOperation(value = "根据多个id删除")
    @PostMapping("deleteByIds")
    public ResponseResult deleteByIds(SystemLogVo systemLogVo) {
        baseService.deleteByIds(systemLogVo.getIds());
        return ResponseResult.build(StatusEnums.DELETE_SUCCESS);
    }
}
