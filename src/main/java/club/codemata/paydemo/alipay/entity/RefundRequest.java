package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class RefundRequest extends BaseEntity {
    private String orderId;

    private String transactionId;

    private String outTradeNo;

    private String refundReason;

    private String refundAmount;
}
