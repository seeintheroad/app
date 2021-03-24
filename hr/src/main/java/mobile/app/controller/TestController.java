package mobile.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
//        Thread thread = new Thread();
//        try {
//            thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "test";
    }
}
