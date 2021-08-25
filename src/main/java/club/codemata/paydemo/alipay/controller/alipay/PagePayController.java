package club.codemata.paydemo.alipay.controller.alipay;

import club.codemata.paydemo.config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aliPay/page")
public class PagePayController {
    @PostMapping("/pay")
    @ResponseBody
    public Object pay() throws AlipayApiException {
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
        request.setBizContent("{\"\"}");
    }
}
