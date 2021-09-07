package club.codemata.paydemo.log.aop;

import club.codemata.paydemo.pm.entity.PayLog;
import club.codemata.paydemo.pm.mapper.IPayLogMapper;
import club.codemata.paydemo.pm.service.IPayLogService;
import club.codemata.paydemo.sys.entity.SystemLog;
import club.codemata.paydemo.sys.mapper.ISystemLogMapper;
import club.codemata.paydemo.sys.service.ISystemLogService;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class ExceptionLogAspect {
    @Autowired
    private ISystemLogService systemLogService;

    @Autowired
    private IPayLogService payLogService;

    @Pointcut("@annotation(club.codemata.paydemo.log.annotation.LogOperation)")
    public void saveLog() {}

    @AfterThrowing(pointcut = "saveLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取请求中的参数转换为JSON字符串
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; ++i) {
                System.out.println(joinPoint.getArgs()[i]);
            }
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (String key : parameterMap.keySet()) {
                String[] values = parameterMap.get(key);
                for (String value : values) {
                    System.out.println("===================key:" + value + "=============================");
                }
            }
        }
        System.out.println("================ExceptionClass:" + e.getClass() + "===============================");
        System.out.println("================" + e.toString() + "==========================");
        System.out.println("================" + e + "===============================");
        System.out.println("================requestUrl:" + request.getRequestURL() + "=============================");
        System.out.println("================ExceptionCause:" + e.getCause() + "===========================");
        System.out.println("================ExceptionMessage:" + e.getMessage() + "===============================");
    }
}
