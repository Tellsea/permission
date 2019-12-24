package cn.tellsea.permission.system.controller;

import cn.tellsea.permission.system.service.RoleInfoService;
import cn.tellsea.permission.system.vo.RoleInfoVo;
import cn.tellsea.walnut.base.controller.BaseController;
import cn.tellsea.walnut.dto.ResponseResult;
import cn.tellsea.walnut.global.enums.StatusEnums;
import cn.tellsea.walnut.plugins.element.ElementTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色表 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "角色表")
@RestController
@RequestMapping("roleInfo")
public class RoleInfoController extends BaseController<RoleInfoService> {

    @ApiOperation(value = "所有角色")
    @GetMapping("listByAll")
    public ResponseResult listByAll() {
        return ResponseResult.build(StatusEnums.SELECT_SUCCESS, baseService.selectAll());
    }

    @ApiOperation(value = "表格数据")
    @PostMapping("list")
    public ElementTable list(RoleInfoVo roleInfoVo) {
        return baseService.listRoleInfo(roleInfoVo);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public ResponseResult save(RoleInfoVo roleInfoVo) {
        return baseService.saveRoleInfo(roleInfoVo);
    }

    @ApiOperation(value = "更新角色")
    @PostMapping("update")
    public ResponseResult update(RoleInfoVo roleInfoVo) {
        return baseService.updateRoleInfo(roleInfoVo);
    }

    @ApiOperation(value = "根据id查询角色")
    @PostMapping("getById")
    public ResponseResult getById(RoleInfoVo roleInfoVo) {
        return baseService.getRoleInfoById(roleInfoVo);
    }

    @ApiOperation(value = "删除角色")
    @PostMapping("delete")
    public ResponseResult delete(RoleInfoVo roleInfoVo) {
        return baseService.deleteRoleInfo(roleInfoVo);
    }
}
