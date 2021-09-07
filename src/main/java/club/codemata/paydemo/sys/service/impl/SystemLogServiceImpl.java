package club.codemata.paydemo.sys.service.impl;

import club.codemata.paydemo.sys.entity.SystemLog;
import club.codemata.paydemo.sys.mapper.ISystemLogMapper;
import club.codemata.paydemo.sys.service.ISystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemLogServiceImpl extends ServiceImpl<ISystemLogMapper, SystemLog> implements ISystemLogService {
}
