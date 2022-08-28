package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/15 14:05
 * Description:
 */
@Configuration
public class GatewayConfig {

    /**
     *  路由 ID ：path_route_atguigu
     *  通过访问 9527 的 /guonei 路径 跳转到 http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();


        return routes.build();

    }
}
