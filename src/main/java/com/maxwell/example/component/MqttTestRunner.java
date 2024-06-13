package com.maxwell.example.component;

import com.maxwell.example.service.MqttPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MqttTestRunner implements CommandLineRunner {

    @Autowired
    private MqttPublisherService mqttPublisherService;

    @Override
    public void run(String... args) throws Exception {
        mqttPublisherService.publish("Test message from Spring Boot");
        System.out.println("Message published");
    }
}
