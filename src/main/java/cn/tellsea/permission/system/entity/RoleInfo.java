package cn.tellsea.permission.system.entity;

import cn.tellsea.walnut.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 角色表 实体类
 *
 * @author Tellsea
 * @date 2019-12-15
 */
@Getter
@Setter
public class RoleInfo extends BaseEntity {

    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

}
