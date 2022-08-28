package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 16:55
 * Description:
 */

@SpringBootApplication
// 表示该模块为客户端
@EnableEurekaClient
// 开启 Discovery 服务发现
@EnableDiscoveryClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
