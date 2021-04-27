package mobile.app.controller;

import com.alibaba.fastjson.JSON;
import feign.Feign;
import mobile.app.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/test1")
    public void test1(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code","1");
        map.put("code1","2");
        ResponseEntity<String> entity = restTemplate.postForEntity("http://hr/hr/testMap3", map, String.class);
        System.out.println(entity);
    }
    @RequestMapping("/testMap")
    public void testMap(){
        TestFeign testFeign = Feign.builder().target(TestFeign.class,"http://localhost:7003/");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code","1");
        map.put("code1","2");
        String body = JSON.toJSONString(map);
//        testFeign.testMap("testMap",map);//RequestParam
//        testFeign.testMap("testMap1",map);//无注解 (不可用)
//        testFeign.testMap("testMap2",map);//RequestParam map
//        testFeign.testMap("testMap4",body);//RequestBody entity
//        testFeign.test("test");//无参
        String testMap3 = testFeign.testMap("hr","testMap3", body);//RequestBody map
        System.out.println(testMap3);

    }
}
