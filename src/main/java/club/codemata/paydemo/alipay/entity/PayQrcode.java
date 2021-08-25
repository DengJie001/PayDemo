package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class PayQrcode extends BaseEntity {
    private String id;

    private String orderId;

    private String qrcode;
}
