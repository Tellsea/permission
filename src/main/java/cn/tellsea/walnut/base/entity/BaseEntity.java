package cn.tellsea.walnut.base.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

/**
 * 基类实体类, 实体公共属性
 *
 * @author Tellsea
 * @date 2019/7/29
 */
@Getter
@Setter
public class BaseEntity {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 计算后的页数
     */
    private int offset;

    /**
     * 总条数
     */
    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }


    @Transient
    private String createUserName;
}
