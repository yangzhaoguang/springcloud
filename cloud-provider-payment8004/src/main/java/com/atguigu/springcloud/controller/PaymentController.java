package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/30 8:25
 * Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port ;

    @RequestMapping("/payment/zk")
    public String paymentZK(){
        return "springcloud with zookeeper : " + port + "\t" + UUID.randomUUID().toString();
    }
}
