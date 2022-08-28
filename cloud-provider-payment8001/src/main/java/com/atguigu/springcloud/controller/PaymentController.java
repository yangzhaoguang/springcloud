package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 18:48
 * Description:
 */
@RestController
@Log4j2
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    // 从配置文件中读取端口号
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
       log.info("====插入结果:" + result);

       if (result > 0){
           return  new CommonResult(200,"插入结果成功:" + serverPort,result);
       }else {
           return  new CommonResult(444,"插入结果失败",null);
       }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(1);
        log.info("====查询结果:" + payment);

        if (payment != null){
            return  new CommonResult(200,"查询成功:" + serverPort ,payment);
        }else {
            return  new CommonResult(444,"查询失败",null);
        }
    }

    /**
     * 自定义Ribbon轮询算法
     * @return
     */
    @GetMapping("/payment/lb")
    public String getLB(){
        return serverPort ;
    }

    /**
     * 演示 OpenFeign 服务提供方超时
     * @return
     */
    @GetMapping("/payment/feign/timeOut")
    public String PaymentFeignTimeOut(){
        try {
            // 暂停 4S
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
