package cn.tellsea.permission.system.controller;

import cn.tellsea.permission.system.service.MapRoleResourceService;
import cn.tellsea.walnut.base.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色资源关联表 前端控制器
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Api(tags = "角色资源关联表")
@RestController
@RequestMapping("mapRoleResource")
public class MapRoleResourceController extends BaseController<MapRoleResourceService> {

}
