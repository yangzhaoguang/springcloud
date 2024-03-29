package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/16 16:00
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient

public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
