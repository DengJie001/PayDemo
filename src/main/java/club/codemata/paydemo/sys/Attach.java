package club.codemata.paydemo.sys;

import club.codemata.paydemo.BaseEntity;
import lombok.Data;

@Data
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
