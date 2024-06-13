package com.maxwell.example.component;

import com.maxwell.example.service.MqttPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MqttTestRunner implements CommandLineRunner {

    @Value("${mqtt.topic}")
    private String topic;

    @Autowired
    private MqttPublisherService mqttPublisherService;

    @Override
    public void run(String... args) throws Exception {
        String requestMessage = "Request: Test message from Spring Boot";
        mqttPublisherService.publish(topic, requestMessage);
        System.out.println("Request message published: " + requestMessage);
    }
}