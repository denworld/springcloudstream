package com.denworld.cloudstream.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.denworld.cloudstream.service.IMessagePublisher;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author ywang Email:denworld@gmail.com
 * @since 2023/03/07 16:28
 */
@RestController
public class PublishController {
    @Resource
    IMessagePublisher publisher;

    @PostMapping("/publish")
    public String publish(@RequestBody String body) {
        JSONObject messageJson = JSONUtil.parseObj(body);
        messageJson.set("UUID", UUID.randomUUID().toString());
        publisher.publish(JSONUtil.toJsonStr(messageJson));
        return "消息发送成功！" + messageJson;
    }
}
