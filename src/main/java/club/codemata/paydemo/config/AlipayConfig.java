package club.codemata.paydemo.config;

public class AlipayConfig {
    // 商户appid
    public static String APPID = "2021000118601463";

    // 应用私钥
    public static String APPLICATION_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCcGEQYgFzKXPpKmUBoOvp8KcvyVG3qb2/vrm20rCaDRjM7C0smrBmQkC0S5NRIZbwhPZ4GWZngTEip8ZnuCxdvvPWeJJsVgOGfNmp90GHnjPBMKMXtTOyqVDOKo0aI0Um3U59LfiT+TvSrDaEJEK3NvpA9Hut19o7ML7By/UplmL2n82dyMZ3OuyDO9g6SSWlowbfvA5P5OylvArnLvKViMNogbvQ5DZ8T0UJ+ucq7jVMaPYb3rTOewhIS1OfCrDVAC7vXdGhmzzRrsqX/f4DkA/ulBqm56ilmhv7aThVrARZJluy5BVm37lciZTgyvfIFtnp/c33h6wrvLLngtlArAgMBAAECggEBAIcRhFMDN8evnrDQXWgTqM2pyR1eq2HRnbVzZOCSmhy7sPblddj30INEDoyrz3j590l4LPZnr/vjZnkPY1gU5um8Q3jdSgjYZeNDzfAiUaVwUjpEicgl6SAWDidn00/ucXAd/tfvRol7vsEI4RCcCxjeTadlyu9fMv9CQNevjyHLKAzatAIdRsMAZy5db9NyyDlWnz5kHZR+wHVNOTBF9nq5c1HE48q/jVkxGikOlDpaYBA7cbZ7sZFNDIivibKk5R9jXz4uHoi57Snc1oqxfh/la7/iCENtgubbNJFnrRHDUUuoditAMypUb4ngzlY7jO82rdUkKnxFXcNvCEwOo7kCgYEA0CrI3J3XRULzpmazLWKHQc8MenDCBKP1OYzI1whrIY3fMAWeY0GGXVof0cWc3lFPx8cga7q+HbwWtuaMO92CtuGX8xEZz/kWXd8SuzMco+HWZ0ICUDTpomi1Vbyq1th9htswqvBnXzXypn2/JvMXCsdv+Y7cyJxF1AYudh7MktUCgYEAv/ZhTRM2gMtFkMbL4MNCdNSAqOow1tKqKcZGcToJ5IEEdOYE8ofyjTSHbcwQqVQj61l9dZZIez+8xLjxnvhQP+5FNAEgy8LYeqhekRRMZYcGsyVLVyuHuCVQWzgeB9I7LHJlSqxuzXB5XjYJ083/IACW7y3f32SM/sj5cdRq1v8CgYBSJkBESAn3LFfI+EiHhZWJE/OBslPuzuFsh7GOoqTchgdpBR6fXvFuj6109D5WwdHxLhUOTpDOXTa9kTgQO/dkwpxbcQk1uL/p5amXtLD9v5cEAtm021zEGfxNzHnC9YZ8HK4VF3BD859Bsugnr9ENEO2Ql59rj7hC1vmo5binzQKBgQC3DJyQQMfyXOPDQK5dcBTJD3J4oIld8JjvKPE3O17/lL/JMSZ6l4SFfhe+bZ9duKxf2oA2Rs5rKMY62RkevC7aJ72573F0nCKOJEu5EKAhGHcdEW0cfJf40ywjMAoC70gaBCPu5yrpoF07p1ALtx2XSLik7xvSDDIfK0oib6pJxQKBgHgD4FigZUrhfiljClHswJncj5+7jNjZHGgpFTnTqQi3ZBtGekDVf8HRc7yBwVDHX/tBjAwgzz7HyPu5pOLvFMYgRciZmOnEzH7dPV1nejTrNC40QpdxVtjmEXsnBZ1DlDWoRw1zDhDU8dDY7nyzXKzW7de6eRtHLUlqANN+Rfg9";

    // 异步通知接口
    public static String NOTIFY_URL = "http://21eb-182-110-23-215.ngrok.io";

    // 页面跳转
    public static String RETURN_URL = "https://www.baidu.com";

    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    // 编码
    public static String CHARSET = "UTF-8";

    // 返回格式
    public static String FORMAT = "json";

    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAln3LBZ9UVXXbhkfJ50GN412HRL5/lyYINbgQyHo0daEFzSogsJd4mTkHVjV1PRpkAytr8kWTlILgijy7Py5tUfDhtG91wn/UXmK+5LyUTqkH3UShux1bebPdd5KGkheJvtsIkMem3uCA1h7IkmGBwcce4e2Pgdb9kTE6xouTDzrGcP8aU2T/oSq/t3ExRESZCx79Q9XNHT+Yeq5vzjfYCsCTQSpeSCpdwVvUgMRBHLo1EKX97BHrsVUphq2/FBE9lUX1O8TrYYtmh/hkA/dj/BvNZVu5ZJmLaQ8mKO4jHRdvgJ3xqBq3maGtGyeeKSL2OPRc3N/zPd6FRNaO7uluvwIDAQAB";

    // rsa2
    public static String SIGN_TYPE = "RSA2";

    // 应用公钥证书路径
    public static String APP_CERT_PATH = "E:\\PayDemo\\src\\main\\resources\\key\\appCertPublicKey_2021000118601463.crt";

    // 支付宝公钥证书路径
    public static String ALIPAY_PUBLIC_CERT_PATH = "E:\\PayDemo\\src\\main\\resources\\key\\alipayCertPublicKey_RSA2.crt";

    // 根证书路径
    public static String ROOT_CERT_PATH = "E:\\PayDemo\\src\\main\\resources\\key\\alipayRootCert.crt";
}
