package mobile.app.controller;

import mobile.app.entity.TestEntity;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

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

    @RequestMapping("/testMap4")
    public String testMap4(@RequestBody TestEntity testEntity) {
        System.out.println(testEntity);
        return "map";
    }
}
