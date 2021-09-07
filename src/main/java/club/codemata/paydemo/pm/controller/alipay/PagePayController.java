package club.codemata.paydemo.pm.controller.alipay;

import club.codemata.paydemo.base.ResData;
import club.codemata.paydemo.config.AlipayConfig;
import club.codemata.paydemo.pm.AlipaySyncNotifyParam;
import club.codemata.paydemo.pm.entity.PayOrder;
import club.codemata.paydemo.pm.entity.PayResult;
import club.codemata.paydemo.pm.service.IPayOrderService;
import club.codemata.paydemo.pm.service.IPayResultService;
import club.codemata.paydemo.pm.service.impl.PayOrderServiceImpl;
import club.codemata.paydemo.utils.BizContentUtils;
import club.codemata.paydemo.utils.UUIDUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.*;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pm/alipay/page")
public class PagePayController {
    // 支付产品码
    private static String PRODUCT_CODE = "FAST_INSTANT_TRADE_PAY";

    @Autowired
    private IPayOrderService payOrderService;

    @Autowired
    private IPayResultService payResultService;

    // http://localhost:8080/alipay/page/pay
    // ckvttb8113@sandbox.com
    @RequestMapping("/pay")
    @ResponseBody
    public Object pay(@RequestParam("amount") String amount) throws AlipayApiException {
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

        String subject = "测试支付宝电脑网站支付-测试BizContentUtils-1000";
        String outTradeNo = UUIDUtils.getId();

        Map<String, Object> bizContentMap = new HashMap<>();
        bizContentMap.put("out_trade_no", outTradeNo);
        bizContentMap.put("product_code", PRODUCT_CODE);
        bizContentMap.put("total_amount", amount);
        bizContentMap.put("subject", subject);
        request.setBizContent(BizContentUtils.toBizContent(bizContentMap));

//        request.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," +
//                "\"product_code\":\"" + PRODUCT_CODE + "\"," +
//                "\"total_amount\":\"" + amount + "\"," +
//                "\"subject\":\"" + subject + "\"}");
        // 设置异步通知接口
        request.setNotifyUrl(AlipayConfig.NOTIFY_URL + "/pm/alipay/page/getPaySyncNotify");
        // 接收响应结果
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            PayOrder payOrder = new PayOrder();
            payOrder.setOutTradeNo(outTradeNo);
            payOrder.setTotalAmount((int) (Float.parseFloat(amount) * 100));
            payOrder.setPayType(PRODUCT_CODE);
            payOrder.setDescription(subject);
            payOrder.setPayWayId("4e9374f4939bb5dbd16496460b8b0865");
            payOrder.setSystemId("ae63928c81475f56fd72abdb3ade7dc9");
            boolean saveOrUpdateRes = payOrderService.saveOrUpdate(payOrder);
            System.out.println("outTradeNo=" + response.getOutTradeNo());
            System.out.println("sellerId=" + response.getSellerId());
            System.out.println("totalAmount=" + response.getTotalAmount());
            System.out.println("tradeNo=" + response.getTradeNo());
        } else {
            return ResData.create("请求失败");
        }
        return response.getBody();
    } // http://localhost:8080/pm/alipay/page/pay?amount=

    @PostMapping("/getPaySyncNotify")
    @ResponseBody
    public String getNotify(@RequestParam("trade_no") String tradeNo,
                          @RequestParam("out_trade_no") String outTradeNo,
                          @RequestParam("buyer_id") String buyerId,
                          @RequestParam("seller_id") String sellerId,
                          @RequestParam("trade_status") String tradeStatus,
                          @RequestParam("total_amount") String totalAmount) throws Exception {
        PayOrder payOrder = new PayOrder();
        QueryWrapper<PayOrder> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(outTradeNo)) {
            queryWrapper.eq("outTradeNo", outTradeNo).eq("deleted", 0);
            payOrder = payOrderService.getOne(queryWrapper);
            if (StringUtils.isNotBlank(buyerId)) {
                payOrder.setPayer(buyerId);
            }
            if (StringUtils.isNotBlank(sellerId)) {
                payOrder.setSellerId(sellerId);
            }
            System.out.println("====================payOrder==========================");
            System.out.println(payOrder);
            boolean saveOrUpdate = payOrderService.saveOrUpdate(payOrder);

            PayResult payResult = new PayResult();
            payResult.setOrderId(payOrder.getId());
            payResult.setTransactionId(tradeNo);
            payResult.setTradeState(tradeStatus);
            // 处理totalAmount
            if (StringUtils.isNotBlank(totalAmount)) {
                payResult.setTotalAmount((int) (Float.parseFloat(totalAmount) * 100));
                payResult.setUserPayAmount((int) (Float.parseFloat(totalAmount) * 100));
            }
            payResultService.saveOrUpdate(payResult);
        }
        System.out.println("============================异步通知信息====================================");
        System.out.println(outTradeNo);
        System.out.println(tradeNo);
        System.out.println(buyerId);
        System.out.println(sellerId);
        System.out.println(tradeStatus);
        System.out.println(totalAmount);
        return "success";
    }

    @RequestMapping("/refund")
    @ResponseBody
    public Object refund(@RequestParam("outTradeNo") String outTradeNo,
                         @RequestParam("tradeNo") String tradeNo,
                         @RequestParam("refundAmount") Integer refundAmount) throws Exception {
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl(AlipayConfig.URL);
        certAlipayRequest.setAppId(AlipayConfig.APPID);
        certAlipayRequest.setPrivateKey(AlipayConfig.APPLICATION_PRIVATE_KEY);
        certAlipayRequest.setFormat(AlipayConfig.FORMAT);
        certAlipayRequest.setCharset(AlipayConfig.CHARSET);
        certAlipayRequest.setSignType(AlipayConfig.SIGN_TYPE);
        certAlipayRequest.setCertPath(AlipayConfig.APP_CERT_PATH);
        certAlipayRequest.setRootCertPath(AlipayConfig.ROOT_CERT_PATH);
        certAlipayRequest.setAlipayPublicCertPath(AlipayConfig.ALIPAY_PUBLIC_CERT_PATH);

        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        String outRequestNo = UUIDUtils.getId();

        request.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"," +
                "\"refund_amount\":\"" + refundAmount + "\"," +
                "\"trade_no\":\"" + tradeNo + "\"," +
                "\"out_request_no\":\"" + outRequestNo + "\"}");
        AlipayTradeRefundResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            response.getBody();
            System.out.println(response.getTradeNo());
        } else {
            System.out.println("========================failed=====================");
        }
        return response.getBody();

    }

    @PostMapping("/query")
    @ResponseBody
    public ResData<Object> query(@RequestBody Map<String, String> map) throws Exception {
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl(AlipayConfig.URL);
        certAlipayRequest.setAppId(AlipayConfig.APPID);
        certAlipayRequest.setPrivateKey(AlipayConfig.APPLICATION_PRIVATE_KEY);
        certAlipayRequest.setFormat(AlipayConfig.FORMAT);
        certAlipayRequest.setCharset(AlipayConfig.CHARSET);
        certAlipayRequest.setSignType(AlipayConfig.SIGN_TYPE);
        certAlipayRequest.setCertPath(AlipayConfig.APP_CERT_PATH);
        certAlipayRequest.setRootCertPath(AlipayConfig.ROOT_CERT_PATH);
        certAlipayRequest.setAlipayPublicCertPath(AlipayConfig.ALIPAY_PUBLIC_CERT_PATH);

        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();

        request.setBizContent("{\"out_trade_no\":\"" + map.get("outTradeNo") + "\"}");
        AlipayTradeQueryResponse response = alipayClient.certificateExecute(request);
        JSONObject res = JSONObject.parseObject(response.getBody());
        return ResData.create(res);
    }

    @RequestMapping("/test")
    public ResData<Object> test() {
        Map<String, Object> map = new HashMap<>();
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        String outTradeNo = "123123123";
        Integer refundAmount = 123;
        String tradeNo = "456123456";
        String outRequestNo = "qwertyuiouio";
        Map<String, Object> map1 = new HashMap<>();
        map1.put("payer", "codemata");
        map1.put("phone", "17746606528");
        map.put("user", map1);
        map.put("out_trade_no", outTradeNo);
        map.put("refund_amount", refundAmount);
        map.put("trade_no", tradeNo);
        map.put("out_request_no", outRequestNo);
        String s = BizContentUtils.toBizContent(map);
        System.out.println(s);
        JSONObject res = JSONObject.parseObject(s);
        return ResData.create(res);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
