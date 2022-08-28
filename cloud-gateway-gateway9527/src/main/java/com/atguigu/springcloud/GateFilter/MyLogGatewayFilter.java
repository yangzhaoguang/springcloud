package com.atguigu.springcloud.GateFilter;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/15 16:22
 * Description:
 */
@Component
@Log4j2
public class MyLogGatewayFilter implements Ordered, GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("======== welcome to MyLogGatewayFilter");
        // 获取参数
        String age = exchange.getRequest().getQueryParams().getFirst("age");
        if (age == null){
            // 拒绝访问
             exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
             // setComplete 表示设置完成
             return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 返回优先级，数字越低 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
