package com.denworld.cloudstream.service.impl;

import com.denworld.cloudstream.service.IMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author ywang Email:denworld@gmail.com
 * @since 2023/03/07 16:31
 */
@EnableBinding(Source.class)
@Slf4j
public class MessagePublishImpl implements IMessagePublisher {

    @Resource
    private MessageChannel output;  // 消息发送管道
    @Override
    public void publish(String message) {
        log.info("发送消息：{}", message);
        output.send(MessageBuilder.withPayload(message).build());
    }
}
