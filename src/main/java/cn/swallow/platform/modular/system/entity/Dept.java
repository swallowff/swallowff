package cn.swallow.platform.modular.system.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * 部门
 */
public class Dept extends BaseEntity<Dept> implements Serializable {
    private Integer sort;   //排序
    private Integer pid;    //父级id
    private String pids;    //所有父级id
    private String simpleName;  //简称
    private String fullName;    //全称
    private String tips;        //提示

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
