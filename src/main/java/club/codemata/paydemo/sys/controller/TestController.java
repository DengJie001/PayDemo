package club.codemata.paydemo.sys.controller;

import club.codemata.paydemo.log.annotation.LogOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/log")
public class TestController {
    @PostMapping("/testLog")
//    @LogOperation
    public String testLog(@RequestBody Map<String, Object> map) {
        for (String key : map.keySet()) {
            System.out.println("=======================key:" + map.get(key) + "==========================");
        }
        System.out.println(3 / 0);
        return "success";
    }
}
