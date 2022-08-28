package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/13 14:59
 * Description:
 */
@SpringBootApplication
// 激活 OpenFeign
@EnableFeignClients
// 开启Hystrix
@EnableHystrix
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class,args);
    }
}
