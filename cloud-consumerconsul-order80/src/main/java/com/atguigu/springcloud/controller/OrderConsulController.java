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
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String getPaymentInfo(){

        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);

        return  result;
    }
}
