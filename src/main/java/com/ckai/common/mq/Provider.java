package com.ckai.common.mq;

import com.ckai.vehicle.dto.warning.WarningDTO;
import com.ckai.vehicle.dto.warning.WarningJson;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Provider {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMsg(String topic, WarningDTO msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
        System.out.println("发送成功"+ msg);
    }

}
