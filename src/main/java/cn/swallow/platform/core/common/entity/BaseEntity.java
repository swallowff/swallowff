package cn.swallow.platform.core.common.entity;

import cn.swallow.platform.core.common.page.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class BaseEntity<T extends BaseEntity> {
    private String id;
    private Date createTime;
    private Date updateTime;
    private Integer version;
    private String orderBy;
    private Page<T> page;
    private boolean isNewRecord;
    private boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public boolean isNewRecord() {
        return isNewRecord && StringUtils.isNotBlank(id);
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
