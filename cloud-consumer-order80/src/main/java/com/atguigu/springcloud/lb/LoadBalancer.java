package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/6 17:26
 * Description:
 */
public interface LoadBalancer {

    /**
     * 选取到列表中的某一个服务
     * @param instanceList 服务列表
     * @return
     */
    ServiceInstance  instance(List<ServiceInstance> instanceList);
}
