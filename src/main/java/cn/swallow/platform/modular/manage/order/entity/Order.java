package cn.swallow.platform.modular.manage.order.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;
import cn.swallow.platform.modular.manage.order.dto.AddressInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shenyu
 * @create 2019/4/1
 */
public class Order extends BaseEntity<Order> {
    private String orderId;     //订单id
    private String tittle;      //订单标题
    private Integer orderFrom;  //订单来源
    private Integer orderType;  //订单类型
    private Date orderTime;     //下单时间
    private BigDecimal orderAmount; //订单金额
    private String wxAppid;             //微信小程序appid
    private String userId;          //下单用户id
    private AddressInfo addressInfo;    //收货信息
    private Integer orderState;    //订单状态

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}
