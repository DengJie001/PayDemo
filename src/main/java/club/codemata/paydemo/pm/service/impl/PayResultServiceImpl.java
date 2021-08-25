package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PayResult;
import club.codemata.paydemo.pm.mapper.IPayResultMapper;
import club.codemata.paydemo.pm.service.IPayResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayResultServiceImpl extends ServiceImpl<IPayResultMapper, PayResult> implements IPayResultService {
}
