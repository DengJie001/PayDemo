package club.codemata.paydemo.pm.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pm_prepayid")
public class PrepayId extends BaseEntity {
    private String orderId;

    private String prepayId;
}
