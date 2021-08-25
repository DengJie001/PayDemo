package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PayOrder;
import club.codemata.paydemo.pm.mapper.IPayOrderMapper;
import club.codemata.paydemo.pm.service.IPayOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayOrderServiceImpl extends ServiceImpl<IPayOrderMapper, PayOrder> implements IPayOrderService {
}
