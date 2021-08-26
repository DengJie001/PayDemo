package club.codemata.paydemo.pm.controller.alipay;

import club.codemata.paydemo.base.ResData;
import club.codemata.paydemo.pm.entity.PayWay;
import club.codemata.paydemo.pm.service.IPayWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/pm/pay/way")
@Controller
public class PayWayController {
    @Autowired
    private IPayWayService payWayService;

    @PostMapping("/modify")
    @ResponseBody
    public ResData<String> modify(@RequestBody PayWay payWay) {
        boolean saveOrUpdateRes = payWayService.saveOrUpdate(payWay);
        if (saveOrUpdateRes) {
            ResData.create("success");
        } else {
            ResData.create("failed");
        }
        return ResData.create("success");
    }
}
