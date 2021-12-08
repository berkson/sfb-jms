package com.example.sfgjms.listener;

import com.example.sfgjms.config.JmsConfig;
import com.example.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * Created by berkson
 * Date: 06/12/2021
 * Time: 23:25
 */
@Component
@RequiredArgsConstructor
public class HelloMessagerListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders headers,
                       Message message) {
        System.out.println("\nPeguei a mensagem!!!!\n");

        System.out.println(helloMessage + "\n");
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloMessage, @Headers MessageHeaders headers,
                               Message message) throws JMSException {
        HelloWorldMessage worldMessage = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World")
                .build();


        //jmsTemplate.convertAndSend((Destination) message.getHeaders().get("jms_replyTo"), "got it!"); using spring message implementation of message
        jmsTemplate.convertAndSend(message.getJMSReplyTo(), worldMessage);
        System.out.println("\nPeguei a mensagem do send and receive!!!!\n");

        System.out.println(helloMessage + "\n");
    }
}
