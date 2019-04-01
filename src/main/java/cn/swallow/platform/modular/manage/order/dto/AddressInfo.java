package cn.swallow.platform.modular.manage.order.dto;

/**
 * @author shenyu
 * @create 2019/4/1
 */
public class AddressInfo {
    private String reciever;
    private Integer gender;
    private String phone;
    private String address;

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
