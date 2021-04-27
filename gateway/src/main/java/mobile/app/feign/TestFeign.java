package mobile.app.feign;

import feign.*;

import java.util.Map;

public interface TestFeign {
    @RequestLine("POST /hr/{url}")
    String testMap(@Param("url") String url, @QueryMap Map queryMap);

    @RequestLine("POST /{base}/{url}")
    @Headers("Content-Type: application/json")
    @Body("{body}")
    String testMap(@Param("base") String base, @Param("url") String url, @Param("body") String body);

    @RequestLine("POST /hr/{url}")
    String test(@Param("url") String url);
}
