package club.codemata.paydemo.common;

import club.codemata.paydemo.utils.BizContentUtils;
import club.codemata.paydemo.utils.UUIDUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class GeneralTest {
    @Test
    public void testUUID() {
        System.out.println(UUIDUtils.getId());
    }

    @Test
    public void testToBizContent() {
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
    }
}
