package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/12 18:27
 * Description:
 */
@Configuration
public class FeignConfig {
    /**
     * 开启 Feign 的日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
