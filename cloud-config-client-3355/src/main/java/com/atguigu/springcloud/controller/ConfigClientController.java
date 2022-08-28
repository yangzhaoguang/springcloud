package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/16 16:02
 * Description:
 */
@RestController
@RefreshScope
public class ConfigClientController {
    // 该配置是 3344 从 github 上的 config-dev.yaml 配置文件读取的
    @Value("${config.info}")
    private String configInfo;
    // 定义一个变量
    private String hello ;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
