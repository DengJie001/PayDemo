package club.codemata.paydemo.pm.controller.alipay;

import club.codemata.paydemo.config.AlipayConfig;
import club.codemata.paydemo.pm.service.IPayOrderService;
import club.codemata.paydemo.utils.UUIDUtils;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alipay/wap")
public class WapPayController {
    private static String PRODUCT_CODE = "QUICK_WAP_PAY";

    @Autowired
    private IPayOrderService payOrderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Object pay(@RequestParam("amount") Integer amount) throws Exception {
        // 构造证书加签请求 并设置公共参数
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        // 支付宝支付网关
        certAlipayRequest.setServerUrl(AlipayConfig.URL);
        // 应用ID
        certAlipayRequest.setAppId(AlipayConfig.APPID);
        // 应用私钥
        certAlipayRequest.setPrivateKey(AlipayConfig.APPLICATION_PRIVATE_KEY);
        // 格式
        certAlipayRequest.setFormat(AlipayConfig.FORMAT);
        // 编码
        certAlipayRequest.setCharset(AlipayConfig.CHARSET);
        // 签名方式
        certAlipayRequest.setSignType(AlipayConfig.SIGN_TYPE);
        // 支付宝根证书
        certAlipayRequest.setRootCertPath(AlipayConfig.ROOT_CERT_PATH);
        // 支付宝证书
        certAlipayRequest.setCertPath(AlipayConfig.APP_CERT_PATH);
        // 支付宝公钥证书
        certAlipayRequest.setAlipayPublicCertPath(AlipayConfig.ALIPAY_PUBLIC_CERT_PATH);

        // 构造请求客户端
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        // 构造手机网站支付请求对象
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();

        // 设置参数
        String subject = "测试手机网站支付";
        String outTradeNo = UUIDUtils.getId();
        String quitUrl = "https://www.baidu.com";
        request.setBizContent("{\"subject\":\"" + subject + "\"," +
                "\"out_trade_no\":\"" + outTradeNo + "\"," +
                "\"quit_url\":\"" + quitUrl + "\"," +
                "\"total_amount\":\"" + amount + "\"," +
                "\"product_code\":\"" + PRODUCT_CODE + "\"}");
        // 发起请求
        AlipayTradeWapPayResponse response = alipayClient.certificateExecute(request);
        System.out.println(response.getBody());
        System.out.println(response.getTradeNo());
        System.out.println(response.getSellerId());
        return response.getBody();
    }
}
