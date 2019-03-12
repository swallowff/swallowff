package cn.swallow.platform.modular.manage.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述: test Entity类
 * @author  shenyu
 * @date
 */

public class TestTable extends BaseEntity<TestTable> implements Serializable {

    private String name;
    private String birthDay;
    private String desc;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}

