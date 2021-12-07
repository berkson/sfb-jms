package com.example.sfgjms.config;

import org.apache.activemq.artemis.api.core.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Created by berkson
 * Date: 06/12/2021
 * Time: 22:48
 */
@Configuration
public class JmsConfig {

    public static final String MY_QUEUE = "my-hello-world";

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
