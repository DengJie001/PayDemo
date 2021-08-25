package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class PayResult extends BaseEntity {
    private String orderId;

    private String transactionId;

    private String tradeState;

    private String tradeStateDescription;

    private String successTime;

    /**
     * 订单标额
     */
    private Integer totalAmount;

    /**
     * 用户实际支付金额
     */
    private Integer userPayAmount;
}
