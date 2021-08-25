package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class PayOrder extends BaseEntity {
    private String systemId;

    private String payWayId;

    private String payType;

    private String outTradeNo;

    private Integer totalAmount;

    private String sellerId;

    private String payer;

    private String description;

    private String currency;
}
