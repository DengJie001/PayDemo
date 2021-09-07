package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_pay_log")
public class PayLog extends BaseEntity {
    private String ipAddress;

    private String url;

    private String params;

    private String requestType;

    private String payWay;

    private String payType;

    private String outTradeNo;

    private String orderId;

    private String exceptionName;

    private String exceptionMessage;
}
