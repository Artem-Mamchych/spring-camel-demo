package com.alexshabanov.cameldemo.listener.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * Represents sample route builder.
 *
 * @author Alexander Shabanov
 */
public final class ListenerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:alexshabanov.cameldemo.greeter").to("greetingHandler");
    }
}
