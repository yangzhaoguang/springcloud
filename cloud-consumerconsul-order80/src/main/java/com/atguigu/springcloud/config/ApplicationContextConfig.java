package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 19:42
 * Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
