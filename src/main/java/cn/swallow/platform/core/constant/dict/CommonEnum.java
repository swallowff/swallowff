package cn.swallow.platform.core.constant.dict;

public interface CommonEnum{

    enum YesOrNo{
        YES(0,"是"),
        NO(1,"否")
        ;

        private Integer code;
        private String name;

        YesOrNo(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    enum Enable {
        ENABLE(0,"启用"),
        DISABLE(1,"停用")
        ;

        private Integer code;

        private String name;

        Enable(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
