package club.codemata.paydemo.alipay.entity;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
public class PayWay extends BaseEntity {
    private String name;

    private String iconPath;

    private Integer status;
}
