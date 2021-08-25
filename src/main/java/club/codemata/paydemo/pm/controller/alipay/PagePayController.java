package club.codemata.paydemo.pm.controller.alipay;

import club.codemata.paydemo.config.AlipayConfig;
import club.codemata.paydemo.pm.entity.PayOrder;
import club.codemata.paydemo.pm.service.IPayOrderService;
import club.codemata.paydemo.utils.UUIDUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/aliPay/page")
public class PagePayController {
    // 支付产品码
    private static String PRODUCT_CODE = "FAST_INSTANT_TRADE_PAY";

    @Autowired
    private IPayOrderService payOrderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Object pay(@RequestParam("amount") Integer amount) throws AlipayApiException {
        // 构造请求公共参数
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        // 支付宝支付网关
        certAlipayRequest.setServerUrl(AlipayConfig.URL);
        // 支付宝应用APPID
        certAlipayRequest.setAppId(AlipayConfig.APPID);
        // 支付宝私钥
        certAlipayRequest.setPrivateKey(AlipayConfig.APPLICATION_PRIVATE_KEY);
        // 格式
        certAlipayRequest.setFormat(AlipayConfig.FORMAT);
        // 编码
        certAlipayRequest.setCharset(AlipayConfig.CHARSET);
        // 支付宝公钥证书
        certAlipayRequest.setAlipayPublicCertPath(AlipayConfig.ALIPAY_PUBLIC_CERT_PATH);
        // 支付宝应用证书
        certAlipayRequest.setCertPath(AlipayConfig.APP_CERT_PATH);
        // 支付宝根证书
        certAlipayRequest.setRootCertPath(AlipayConfig.ROOT_CERT_PATH);
        // 签名方式
        certAlipayRequest.setSignType(AlipayConfig.SIGN_TYPE);

        // 构造请求客户端
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        // 构造支付请求
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        String subject = "测试支付宝电脑网站支付-1";

        request.setBizContent("{\"out_trade_no\":\"" + UUIDUtils.getId() + "\"," +
                "\"product_code\":\"" + PRODUCT_CODE + "\"," +
                "\"total_amount\":\"" + amount + "\"," +
                "\"subject\":\"" + subject + "\"}");
        // 接收响应结果
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            PayOrder payOrder = new PayOrder();

        } else {

        }
        return null;
    }
}
