package com.alexshabanov.cameldemo.greeter.service.support;

import com.alexshabanov.cameldemo.domain.Greeting;
import com.alexshabanov.cameldemo.greeter.service.GreeterService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;

@Service
public final class GreeterServiceImpl implements GreeterService {


    @Override
    public void send(final Greeting greeting) {
        CamelContext context = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        context.addComponent("test-jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        ProducerTemplate template = context.createProducerTemplate();
        try {
            context.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        template.sendBody("activemq:alexshabanov.cameldemo.greeter", greeting.getMessage());
    }
}