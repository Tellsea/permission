package cn.tellsea.permission.system.vo;

import cn.tellsea.permission.system.entity.RoleInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色表 Vo类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class RoleInfoVo extends RoleInfo {

    private String resourceIds;

    private String resourceName;
}
