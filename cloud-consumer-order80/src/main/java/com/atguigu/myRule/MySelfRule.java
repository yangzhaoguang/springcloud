package com.atguigu.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/5 14:57
 * Description:
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 随机的负载算法
        return  new RandomRule();
    }
}
