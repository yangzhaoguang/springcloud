package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/19 14:38
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NaconsConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NaconsConfigMain3377.class,args);
    }
}
