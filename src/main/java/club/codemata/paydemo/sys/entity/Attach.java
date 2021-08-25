package club.codemata.paydemo.sys.entity;

import club.codemata.paydemo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_attach")
public class Attach extends BaseEntity {
    private String realName;

    private String saveName;

    private String savePath;

    private Integer fileSize;

    private String fileType;

    private String smallName;

    private String midName;

    private String largeName;
}
