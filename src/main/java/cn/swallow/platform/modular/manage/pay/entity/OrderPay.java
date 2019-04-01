package cn.swallow.platform.modular.manage.pay.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @author shenyu
 * @create 2019/4/1
 */
public class OrderPay extends BaseEntity<OrderPay> {
    private String orderId;
    private Integer payChannel;
    private Integer payType;
    private String requestId;       //支付流水号
    private BigDecimal payAmount;
    private BigDecimal reduceAmount;
    private BigDecimal expressFee;
    private Integer payState;       //支付状态 0:待支付 1:支付中 2:支付成功 3:支付失败 4:退款


}
