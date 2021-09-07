package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PayLog;
import club.codemata.paydemo.pm.mapper.IPayLogMapper;
import club.codemata.paydemo.pm.service.IPayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayLogServiceImpl extends ServiceImpl<IPayLogMapper, PayLog> implements IPayLogService {
}
