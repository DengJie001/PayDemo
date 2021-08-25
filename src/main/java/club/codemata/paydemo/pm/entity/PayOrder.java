package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_pay_order")
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
