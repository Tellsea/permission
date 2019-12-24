package cn.tellsea.permission.system.entity;

import cn.tellsea.walnut.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 角色资源关联表 实体类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class MapRoleResource extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单/按钮ID
     */
    private Integer resourceId;

}
