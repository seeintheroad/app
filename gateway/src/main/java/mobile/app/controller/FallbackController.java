package mobile.app.controller;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RefreshScope
@RestController
public class FallbackController {
    @Value("${config}")
    private String config;
    @RequestMapping("/test")
    public String test(){
        return config;
    }
    @RequestMapping("fallback")
    public ResponseEntity fallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("服务暂不可用！！！！");
    }
    @RequestMapping("fallback1")
    public Mono<Map<String, Object>> fallback(ServerWebExchange exchange) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 60002);
        result.put("data", null);
        Exception exception = exchange.getAttribute(ServerWebExchangeUtils.HYSTRIX_EXECUTION_EXCEPTION_ATTR);
        ServerWebExchange delegate = ((ServerWebExchangeDecorator) exchange).getDelegate();
        log.error("接口调用失败，URL={}", delegate.getRequest().getURI(), exception);
        if (exception instanceof HystrixTimeoutException) {
            result.put("msg", "接口调用超时");
        } else if (exception != null && exception.getMessage() != null) {
            result.put("msg", "接口调用失败: " + exception.getMessage());
        } else {
            result.put("msg", "接口调用失败");
        }
        return Mono.just(result);
    }


}
