package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_pay_way")
public class PayWay extends BaseEntity {
    private String name;

    private String iconPath;

    private Integer status;
}
