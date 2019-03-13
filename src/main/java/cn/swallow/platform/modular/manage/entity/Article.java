package cn.swallow.platform.modular.manage.entity;
import cn.swallow.platform.core.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.String;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

/**
 * 描述: Article Entity类
 * @author shenyu
 * @date 2019-03-13 15:13:32
 */

public class Article extends BaseEntity<Article> implements Serializable {

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
    private Integer age;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Timestamp updateTime;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}

