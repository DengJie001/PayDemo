package club.codemata.paydemo.pm.mapper;

import club.codemata.paydemo.pm.entity.PayLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayLogMapper extends BaseMapper<PayLog> {
}
