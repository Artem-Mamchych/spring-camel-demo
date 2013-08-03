package com.alexshabanov.cameldemo.greeter.service.support;

import com.alexshabanov.cameldemo.domain.Greeting;
import com.alexshabanov.cameldemo.greeter.service.GreeterService;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.StreamMessage;

@Service
public final class GreeterServiceImpl implements GreeterService {

    @Resource(name = "greeterJmsOperations")
    private JmsOperations jmsOperations;

    @Override
    public void send(final Greeting greeting) {
        jmsOperations.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                final StreamMessage message = session.createStreamMessage();
                message.writeString(greeting.getMessage());
                message.writeInt(greeting.getCount());
                return message;
            }
        });
    }
}