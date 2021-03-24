package mobile.app.controller;

import mobile.app.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping("/saveLog")
    public String saveLog(String msg) {
        return feignService.saveLog(msg);
    }
}
