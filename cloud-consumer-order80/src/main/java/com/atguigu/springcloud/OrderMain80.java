package com.atguigu.springcloud;

import com.atguigu.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 19:32
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
// name 表示调用的微服务， configuration 自定义的规则
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
