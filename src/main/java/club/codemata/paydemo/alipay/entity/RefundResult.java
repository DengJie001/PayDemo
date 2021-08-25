package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class RefundResult extends BaseEntity {
    private String refundRequestId;

    private String refundId;

    private String channel;

    private String userReceiveAccount;

    private String status;

    private String realRefund;

    private String currency;
}
