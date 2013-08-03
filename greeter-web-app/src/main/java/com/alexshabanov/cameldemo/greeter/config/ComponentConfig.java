package com.alexshabanov.cameldemo.greeter.config;

import com.alexshabanov.cameldemo.greeter.controller.PublicController;
import com.alexshabanov.cameldemo.greeter.service.support.GreeterServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Application components configuration.
 */
@Configuration
@ComponentScan(basePackageClasses = {PublicController.class, GreeterServiceImpl.class})
@ImportResource("classpath:/spring/jms-context.xml")
public class ComponentConfig {
}
