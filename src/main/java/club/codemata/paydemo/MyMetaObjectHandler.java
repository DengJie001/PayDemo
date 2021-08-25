package club.codemata.paydemo;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleted", 0, metaObject);
        this.setFieldValByName("sortedNum", 1, metaObject);
        this.setFieldValByName("createdAt", System.currentTimeMillis(), metaObject);
        this.setFieldValByName("updatedAt", System.currentTimeMillis(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedAt", System.currentTimeMillis(), metaObject);
    }
}
