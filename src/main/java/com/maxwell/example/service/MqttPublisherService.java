package com.maxwell.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {

    @Autowired
    private MessageChannel mqttOutboundChannel;

    public void publish(String message) {
        publish("yourTopic", message);
    }

    public void publish(String topic, String message) {
        mqttOutboundChannel.send(MessageBuilder.withPayload(message).setHeader("mqtt_topic", topic).build());
    }

}
