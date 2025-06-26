package com.ckai.common.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Consumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {
        // 构建消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("DemoConsumer");

        // 配置NameServer地址
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        // 订阅Topic（需与生产者Topic一致）
        consumer.subscribe("warn", "*");

        // RestTemplate restTemplate;
        //
        // // 设置HTTP请求头
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        //
        // // 创建HTTP请求实体，包含消息体和请求头
        // String jsonMessage = "";
        // HttpEntity<String> requestEntity = new HttpEntity<>(jsonMessage, headers);

        // 注册消息监听回调
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs,
                    ConsumeConcurrentlyContext context
            ) {
                msgs.forEach(messageExt -> {
                    try {
                        String messageBody = new String(
                                messageExt.getBody(),
                                RemotingHelper.DEFAULT_CHARSET
                        );
                        System.out.println("收到消息: " + messageBody);
                    } catch (UnsupportedEncodingException e) {
                        // 处理编码异常
                    }
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者
        consumer.start();
        System.out.println("Consumer Started");  // 修正为println更规范
    }
}

