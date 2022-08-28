package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/30 9:13
 * Description:
 */
@RestController
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    public String getPaymentInfo(){

        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        return  result;
    }
}
