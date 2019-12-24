package cn.tellsea.permission.system.vo;

import cn.tellsea.permission.system.entity.ResourceInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 资源表 Vo类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class ResourceInfoVo extends ResourceInfo {

    private List<ResourceInfoVo> children;
}
