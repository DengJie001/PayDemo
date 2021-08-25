package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_pay_qrcode")
public class PayQrcode extends BaseEntity {
    private String id;

    private String orderId;

    private String qrcode;
}
