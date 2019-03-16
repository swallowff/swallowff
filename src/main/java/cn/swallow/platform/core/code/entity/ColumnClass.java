package cn.swallow.platform.core.code.entity;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class ColumnClass {
    /** 数据库字段名称 **/
    private String columnName;
    /** 数据库字段类型 **/
    private String columnType;
    /** 数据库字段首字母大写且去掉下划线字符串 **/
    private String firstUppercase;
    /** 数据库字段注释 **/
    private String columnComment;

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getFirstUppercase() {
        return firstUppercase;
    }

    public void setFirstUppercase(String firstUppercase) {
        this.firstUppercase = firstUppercase;
    }
}
