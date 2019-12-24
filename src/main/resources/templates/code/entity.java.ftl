package ${package.Entity};

import com.alibaba.fastjson.annotation.JSONField;
import ${cfg.base}.entity.BaseEntity;
<#if entityLombokModel>
import lombok.Getter;
import lombok.Setter;
</#if>

import javax.persistence.*;
import java.util.Date;

/**
 * ${table.comment!} 实体类
 *
 * @author ${author}
 * @date ${date}
 */
@Getter
@Setter
public class ${entity} extends ${superEntityClass} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
     * ${field.comment}
     */
    <#if "id" == field.name>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    </#if>
    <#if "create_time" == field.name>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if "modify_time" == field.name>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if field.propertyType == "LocalDateTime">
    private Date ${field.propertyName};
    <#elseif field.name == "status">
    private Integer ${field.propertyName};
    <#else>
    private ${field.propertyType} ${field.propertyName};
    </#if>

</#list>
<#------------  END 字段循环遍历  tinyint 转 Integer ---------->
}
