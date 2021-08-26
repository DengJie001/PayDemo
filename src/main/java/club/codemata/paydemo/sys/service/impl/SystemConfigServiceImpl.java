package club.codemata.paydemo.sys.service.impl;

import club.codemata.paydemo.sys.entity.SystemConfig;
import club.codemata.paydemo.sys.mapper.ISystemConfigMapper;
import club.codemata.paydemo.sys.service.ISystemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigServiceImpl extends ServiceImpl<ISystemConfigMapper, SystemConfig> implements ISystemConfigService {
}
