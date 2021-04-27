package mobile.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mobile.app.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("测试模块")
@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @ApiOperation("保存日志")
    @RequestMapping("/saveLog")
    public String saveLog(String msg) {
        return feignService.saveLog(msg);
    }
}
