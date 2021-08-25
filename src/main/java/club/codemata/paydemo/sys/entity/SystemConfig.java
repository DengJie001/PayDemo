package club.codemata.paydemo.sys.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "system_config")
public class SystemConfig extends BaseEntity {
    private String name;

    private String description;

    private String appId;

    private String appKey;

    private String alipayRootCert;

    private String alipayPublicKeyCet;

    private String appPublicKeyCert;
}
