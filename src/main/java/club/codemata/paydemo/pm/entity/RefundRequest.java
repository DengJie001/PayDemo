package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_refund_request")
public class RefundRequest extends BaseEntity {
    private String orderId;

    private String transactionId;

    private String outTradeNo;

    private String refundReason;

    private String refundAmount;
}
