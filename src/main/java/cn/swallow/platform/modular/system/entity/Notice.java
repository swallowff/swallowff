package cn.swallow.platform.modular.system.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class Notice extends BaseEntity<Notice> {
    private String tittle;
    private Integer type;
    private String content;
    private Integer creator;
    private String toUser;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
