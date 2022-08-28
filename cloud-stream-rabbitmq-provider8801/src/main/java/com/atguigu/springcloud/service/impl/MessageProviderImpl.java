package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * Handsome Man.
 * <p>
 * Author: YZG
 * Date: 2022/6/17 16:03
 * Description:
 */

/*
    不需要加 @Service 注解，注意该实现类不在是之前的 service 层，而是和 RabbitMQ 打交道的 service 层
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output ;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 发送一条消息
        output.send(MessageBuilder.withPayload(serial).build());

        return serial;
    }
}
