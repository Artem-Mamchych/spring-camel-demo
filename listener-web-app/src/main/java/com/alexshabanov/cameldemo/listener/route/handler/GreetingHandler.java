package com.alexshabanov.cameldemo.listener.route.handler;

import com.alexshabanov.cameldemo.domain.Greeting;
import com.alexshabanov.cameldemo.listener.service.GreetingSinkService;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.StreamMessage;
import javax.jms.TextMessage;

/**
 * Processor that fetches Greeting message from the JMS channel.
 *
 * @author Alexander Shabanov
 */
public final class GreetingHandler implements Processor {
    private final Logger log = LoggerFactory.getLogger(GreetingHandler.class);

    @Autowired
    private GreetingSinkService greetingSinkService;

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("Got exchange id={}", exchange.getExchangeId());
        Message in = exchange.getIn();
        final String message = in.getBody(String.class);
        final Greeting greeting = new Greeting(message);
        greetingSinkService.putGreeting(greeting);
        log.info("- Parsed {}", message);
    }
}
