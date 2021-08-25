package club.codemata.paydemo.alipay.mapper;

import club.codemata.paydemo.alipay.entity.PayOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayOrderMapper extends BaseMapper<PayOrder> {
}
