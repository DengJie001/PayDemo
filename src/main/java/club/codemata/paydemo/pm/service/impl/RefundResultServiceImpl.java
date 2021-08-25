package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.RefundResult;
import club.codemata.paydemo.pm.mapper.IRefundResultMapper;
import club.codemata.paydemo.pm.service.IRefundResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RefundResultServiceImpl extends ServiceImpl<IRefundResultMapper, RefundResult> implements IRefundResultService {
}
