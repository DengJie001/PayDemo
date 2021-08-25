package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PayQrcode;
import club.codemata.paydemo.pm.mapper.IPayQrcodeMapper;
import club.codemata.paydemo.pm.service.IPayQrcodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayQrcodeServiceImpl extends ServiceImpl<IPayQrcodeMapper, PayQrcode> implements IPayQrcodeService {
}
