package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/30 10:27
 * Description:
 */
@RestController
public class PaymentConsulController {
    @Value("${server.port}")
    private String port ;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul : " + port + "\t" + UUID.randomUUID().toString();
    }

}
