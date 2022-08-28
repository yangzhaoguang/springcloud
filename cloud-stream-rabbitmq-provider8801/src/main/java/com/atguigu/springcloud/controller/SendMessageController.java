package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/17 16:15
 * Description:
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String getMessage(){
        // 发送
       return messageProvider.send();
    }
}
