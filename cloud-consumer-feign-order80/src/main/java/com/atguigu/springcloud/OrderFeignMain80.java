package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Handsome Ma6n.
 * <p>
 * Author: YZG
 * Date: 2022/6/7 13:04
 * Description:
 */
@SpringBootApplication
// 开启Feign 服务
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
