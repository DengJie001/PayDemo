package club.codemata.paydemo.alipay.mapper;

import club.codemata.paydemo.alipay.entity.PayWay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayWayMapper extends BaseMapper<PayWay> {
}
