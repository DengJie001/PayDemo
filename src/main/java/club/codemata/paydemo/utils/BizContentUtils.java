package club.codemata.paydemo.utils;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 将Map转换为支付宝所有需要的参数字符串
 */
public class BizContentUtils {
    public static String toBizContent(Map<String, Object> map) {
        Set<String> keys = map.keySet();
        StringBuffer bizContent = new StringBuffer("{");
        int index = 1;
        for (String key : keys) {
            bizContent.append("\"").append(key).append("\":");
            if (map.get(key) instanceof Map) {
                Map<String, Object> value = (Map<String, Object>) map.get(key);
                // 递归 YYDS
                bizContent.append("\"").append(BizContentUtils.toBizContent(value)).append("\"");
                System.out.println("\"" + BizContentUtils.toBizContent(value) + "\"");
            } else {
                bizContent.append("\"").append(map.get(key)).append("\"");
            }
            if (index < keys.size()) {
                bizContent.append(",");
            }
            ++index;
        }
        bizContent.append("}");
        return bizContent.toString();
    }
}
