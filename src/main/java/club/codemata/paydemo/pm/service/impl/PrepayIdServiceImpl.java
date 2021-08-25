package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.PrepayId;
import club.codemata.paydemo.pm.mapper.IPrepayIdMapper;
import club.codemata.paydemo.pm.service.IPrepayIdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PrepayIdServiceImpl extends ServiceImpl<IPrepayIdMapper, PrepayId> implements IPrepayIdService {
}
