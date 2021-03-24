package mobile.common.controller;

import mobile.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    CommonService commonService;

    @RequestMapping("/saveLog")
    public String saveLog(@RequestBody String msg) {
        System.out.println("============="+msg);
        System.out.println("进行业务逻辑...");
        return msg;
    }
}
