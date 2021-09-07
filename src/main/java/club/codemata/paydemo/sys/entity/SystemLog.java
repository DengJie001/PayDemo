package club.codemata.paydemo.sys.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_system_log")
public class SystemLog extends BaseEntity {
    private String ipAddress;

    private String url;

    private String params;

    private String requestType;

    private String exceptionName;

    private String exceptionMessage;
}
