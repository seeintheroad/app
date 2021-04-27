package mobile.app.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mobile.app.entity.TestEntity;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@Api("测试模块")
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @ApiOperation("testMap")
    @RequestMapping("/testMap")
    public String testMap(@RequestParam("code") String param1, @RequestParam("code1") String param2) {
        System.out.println(param1);
        System.out.println(param2);
        return "map";
    }

    @RequestMapping("/testMap1")
    public String testMap1(Map<String, Object> map) {
        System.out.println(map);
        return "map";
    }

    @RequestMapping("/testMap2")
    public String testMap2(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return "map";
    }

    @RequestMapping("/testMap3")
    public String testMap3(@RequestBody Map<String, Object> map) {
        return JSONObject.toJSONString(map);
    }

    @ApiOperation("testMap4")
    @RequestMapping("/testMap4")
    @ApiOperationSupport(includeParameters = {"code"})
    public String testMap4(@RequestBody TestEntity testEntity) {
        System.out.println(testEntity);
        return "map";
    }
    @ApiOperation("testMap5")
    @RequestMapping("/testMap5")
    @ApiOperationSupport(ignoreParameters = {"code1"})
    public String testMap5(@RequestBody TestEntity testEntity) {
        System.out.println(testEntity);
        return "map";
    }
}
