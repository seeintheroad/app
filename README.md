# springcloud

# 1.注册中心-nacos

该项目使用的注册中心为nacos，但我的nacos是搭建在windows的，当时看的教程，还需要起虚拟机，就没有往linux上部署。

注意：==我的nacos没有配置持久化和集群==

# 2.网关-gateway

使用的gateway来进行多个服务的统一分发管理，里面结合了feign的fallback统一配置请求超时处理

# 3.服务调用-openfeign

我的项目只是个模板，里面只是简单的使用了一下，可以进行参考

# 4.配置中心-nacos

这个项目网关的配置使用nacos的