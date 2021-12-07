package com.example.sfgjms.listener;

import com.example.sfgjms.config.JmsConfig;
import com.example.sfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by berkson
 * Date: 06/12/2021
 * Time: 23:25
 */
@Component
public class HelloMessagerListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders headers,
                       Message message) {
        System.out.println("\nPeguei a mensagem!!!!\n");

        System.out.println(helloMessage + "\n");
    }
}
