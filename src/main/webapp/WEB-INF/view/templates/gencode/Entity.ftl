package ${package_name}.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述: test Entity类
 * @author  ${author}
 * @date  ${date}
 */

public class ${class_name} extends BaseEntity<${class_name}> implements Serializable {

    <#if entity_column?exists>
        <#list entity_column as entity>
            <#if (entity.columnType = 'varchar' || entity.columnType = 'text' || entity.columnType = 'char')>
    private String ${entity.changeColumnName?uncap_first};
            </#if>
            <#if (entity.columnType == 'timestamp')>
    private Date ${entity.changeColumnName?uncap_first};
            </#if>
            <#if (entity.columnType == 'date' || entity.columnType == 'datetime')>
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ${entity.changeColumnName?uncap_first};
            </#if>
            <#if (entity.columnType == 'tinyint' || entity.columnType == 'int')>
    private Integer ${entity.changeCllumnName?uncap_first};
            </#if>
        </#list>
    </#if>
<#if entity_column?exists>
    <#list entity_column as entity>
        <#if (entity.columnType = 'varchar' || entity.columnType = 'text')>
    public String get${entity.changeColumnName}() {
        return this.${entity.changeColumnName?uncap_first};
    }

    public void set${entity.changeColumnName}(String ${entity.changeColumnName?uncap_first}) {
        this.${entity.changeColumnName?uncap_first} = ${entity.changeColumnName?uncap_first};
    }

        </#if>
        <#if entity.columnType = 'timestamp' >
    public Date get${entity.changeColumnName}() {
        return this.${entity.changeColumnName?uncap_first};
    }

    public void set${entity.changeColumnName}(Date ${entity.changeColumnName?uncap_first}) {
        this.${entity.changeColumnName?uncap_first} = ${entity.changeColumnName?uncap_first};
    }

        </#if>
    </#list>
</#if>

}

