package ${package_name}.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述: test Entity类
 * @author  ${author}
 * @date
 */

public class ${class_name} extends BaseEntity<${class_name}> implements Serializable {

    <#if table_columns?exists>
        <#list table_columns as column>
            <#if (column.columnType = 'VARCHAR' || column.columnType = 'TEXT' || column.columnType = 'CHAR')>
    private String ${column.changeColumnName?uncap_first};
            </#if>
            <#if (column.columnType == 'TIMESTAMP')>
    private Date ${column.changeColumnName?uncap_first};
            </#if>
            <#if (column.columnType == 'DATE' || column.columnType == 'DATETIME')>
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ${column.changeColumnName?uncap_first};
            </#if>
            <#if (column.columnType == 'TINYINT' || column.columnType == 'INT')>
    private Integer ${column.changeColumnName?uncap_first};
            </#if>
        </#list>
    </#if>

<#if table_columns?exists>
    <#list table_columns as column>
        <#if (column.columnType = 'VARCHAR' || column.columnType = 'TEXT')>
    public String get${column.changeColumnName}() {
        return this.${column.changeColumnName?uncap_first};
    }

    public void set${column.changeColumnName}(String ${column.changeColumnName?uncap_first}) {
        this.${column.changeColumnName?uncap_first} = ${column.changeColumnName?uncap_first};
    }

        </#if>
        <#if column.columnType = 'TIMESTAMP' >
    public Date get${column.changeColumnName}() {
        return this.${column.changeColumnName?uncap_first};
    }

    public void set${column.changeColumnName}(Date ${column.changeColumnName?uncap_first}) {
        this.${column.changeColumnName?uncap_first} = ${column.changeColumnName?uncap_first};
    }

        </#if>
    </#list>
</#if>

}

