package tech.nullpointerexception.jmsdemo.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.nullpointerexception.jmsdemo.config.JmsConfig;
import tech.nullpointerexception.jmsdemo.model.HelloWorldMessage;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000) //estamos haciendo que se ejecute periódicamente
    public void sendMessage() {
        System.out.println("Sending a message.");
        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello world!!!")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
        System.out.println("Message Sent!!!");
    }
}
