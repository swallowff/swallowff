package cn.swallow.platform.modular.api.reqresp;

import java.io.Serializable;

/**
 * @author shenyu
 * @create 2019/4/2
 */
public class TestRespModel implements Serializable {
    private Integer id;
    private String name;

    public TestRespModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
