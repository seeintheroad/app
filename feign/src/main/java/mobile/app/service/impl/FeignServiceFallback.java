package mobile.app.service.impl;

import feign.hystrix.FallbackFactory;
import mobile.app.service.FeignService;
import org.springframework.stereotype.Component;

/**
 *  自定义服务降级,例如: 访问的服务挂掉
 *
 */
@Component
public class FeignServiceFallback implements FallbackFactory<FeignService> {

    public FeignService create(Throwable throwable) {
        return new FeignService() {
            public String saveLog(String msg) {
                return "保存日志功能暂不可用!!";
            }
        };
    }
}

