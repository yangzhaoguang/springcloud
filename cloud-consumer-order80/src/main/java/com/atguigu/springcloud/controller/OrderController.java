package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/5/19 19:34
 * Description:
 */
@RestController
@Log4j2
public class OrderController {

    // public static final String PAYMENT_URL = "http://localhost:8001";
    // 根据服务名称实现负载均衡
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate ;
    @Autowired
    private LoadBalancer loadBalancer ;
    @Autowired
    private DiscoveryClient discoveryClient ;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        // 发送POST 请求
        // 第一个参数: url
        // 第二个参数: 参数
        // 第三个参数: 返回类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        // 发送 GET 请求
        // 第一个参数: url
        // 第二个参数: 返回类型
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id")Long id){
        // getForEntity 返回对象是 ResponseEntity 包含了响应中的一些重要信息
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        // 判断状态码是否是以 2 开头的
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getLB(){
        // 获取所有的服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0){
            return  null ;
        }
        ServiceInstance instance = loadBalancer.instance(instances);

        URI uri = instance.getUri();
      return   restTemplate.getForObject(uri + "/payment/lb",String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }
}
