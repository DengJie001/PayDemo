package club.codemata.paydemo.pm;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
public class AlipaySyncNotifyParam {
    private String notifyTime;

    private String tradeNo;

    private String outTradeNo;

    private String buyer;

    private String sellerId;

    private String tradeStatue;

    /**
     * 订单标额
     */
    private String totalAmount;

    /**
     * 订单实际付款金额
     */
    private String receiptAmount;

    /**
     * 退款总金额
     */
    private String refundFee;

    private String subject;
}
