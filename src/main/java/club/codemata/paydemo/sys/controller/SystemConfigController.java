package club.codemata.paydemo.sys.controller;

import club.codemata.paydemo.base.ResData;
import club.codemata.paydemo.sys.entity.SystemConfig;
import club.codemata.paydemo.sys.service.ISystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sys/systemConfig")
public class SystemConfigController {
    @Autowired
    private ISystemConfigService systemConfigService;

    @PostMapping("/modify")
    public ResData<Object> modify(@RequestBody SystemConfig systemConfig) {
        boolean saveOrUpdateRes = systemConfigService.saveOrUpdate(systemConfig);
        return ResData.create(saveOrUpdateRes);
    }
}
