package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/17 16:40
 * Description:
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    // 接受消息
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接收到的消息: " + message.getPayload() + "端口号: " + serverPort);

    }
}
