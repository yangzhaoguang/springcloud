package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/6 17:26
 * Description:
 */
@Component
public class MyLB implements LoadBalancer {

    // 原子整数型
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    private int incrementAndGetModulo() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            // compareAndSet 比较并且转换， 将 current 转换成 next 值
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****** 第几次访问，next: " + next);
        return  next ;
    }

    /**
     *
     * @param instanceList 服务列表
     * @return 返回具体的服务
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> instanceList) {
        int index = incrementAndGetModulo() % instanceList.size();

        return instanceList.get(index);
    }
}
