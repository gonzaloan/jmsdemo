package tech.nullpointerexception.jmsdemo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tech.nullpointerexception.jmsdemo.config.JmsConfig;
import tech.nullpointerexception.jmsdemo.model.HelloWorldMessage;

import javax.jms.Message;

@Component
public class HelloWorldMessageListener {

    //Payload le dirá a spring que haga un deserialize del mensaje.
    //Headers, le dirá a Spring que saque las cabeceras del mensaje.
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers,
                       Message message){

        System.out.println("I got a message!! ");
        System.out.println(helloWorldMessage);
    }
}
