package cn.tellsea.permission.system.controller;

import cn.tellsea.permission.system.entity.ResourceInfo;
import cn.tellsea.permission.system.service.ResourceInfoService;
import cn.tellsea.walnut.base.controller.BaseController;
import cn.tellsea.walnut.dto.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源表 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "资源表")
@RestController
@RequestMapping("resourceInfo")
public class ResourceInfoController extends BaseController<ResourceInfoService> {

    @ApiOperation(value = "资源树")
    @GetMapping("tree")
    public ResponseResult tree() {
        return baseService.listResourceInfoByTree();
    }

    @ApiOperation(value = "新增资源")
    @PostMapping("save")
    public ResponseResult save(ResourceInfo resourceInfo) {
        return baseService.saveResourceInfo(resourceInfo);
    }

    @ApiOperation(value = "更新资源")
    @PostMapping("update")
    public ResponseResult update(ResourceInfo resourceInfo) {
        return baseService.updateResourceInfo(resourceInfo);
    }

    @ApiOperation(value = "根据id查询资源")
    @PostMapping("getById")
    public ResponseResult getById(ResourceInfo resourceInfo) {
        return baseService.getResourceInfoById(resourceInfo);
    }

    @ApiOperation(value = "删除资源")
    @PostMapping("delete")
    public ResponseResult delete(ResourceInfo resourceInfo) {
        return baseService.deleteResourceInfo(resourceInfo);
    }
}
