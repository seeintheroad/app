package mobile.app.service;

import mobile.app.service.impl.FeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "common",path = "common",fallbackFactory = FeignServiceFallback.class)
public interface FeignService {
    @RequestMapping("/saveLog")
     String saveLog(String msg);
}
