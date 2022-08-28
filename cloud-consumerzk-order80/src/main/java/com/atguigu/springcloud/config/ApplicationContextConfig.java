package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/30 9:10
 * Description:
 */
@Configuration
public class ApplicationContextConfig {


    @Bean // 远程调用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
