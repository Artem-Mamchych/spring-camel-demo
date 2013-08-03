package com.alexshabanov.cameldemo.greeter.service;

import com.alexshabanov.cameldemo.domain.Greeting;

public interface GreeterService {
    void send(Greeting greeting);
}