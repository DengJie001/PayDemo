package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PayWay;
import club.codemata.paydemo.pm.mapper.IPayWayMapper;
import club.codemata.paydemo.pm.service.IPayWayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayWayServiceImpl extends ServiceImpl<IPayWayMapper, PayWay> implements IPayWayService {
}
