package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class PrepayId extends BaseEntity {
    private String orderId;

    private String prepayId;
}
