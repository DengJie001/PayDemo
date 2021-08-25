package club.codemata.paydemo.pm.service.impl;

import club.codemata.paydemo.pm.entity.RefundRequest;
import club.codemata.paydemo.pm.mapper.IRefundRequestMapper;
import club.codemata.paydemo.pm.service.IRefundRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RefundRequestServiceImpl extends ServiceImpl<IRefundRequestMapper, RefundRequest> implements IRefundRequestService {
}
