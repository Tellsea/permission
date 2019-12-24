package ${package.Controller};

import ${package.Service}.${table.serviceName};
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @date ${date}
 */
@Api(tags = "${table.comment!}")
@RestController
@RequestMapping("${table.xmlName}")
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName}> {

}
