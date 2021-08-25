package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_refund_result")
public class RefundResult extends BaseEntity {
    private String refundRequestId;

    private String refundId;

    private String channel;

    private String userReceiveAccount;

    private String status;

    private String realRefund;

    private String currency;
}
