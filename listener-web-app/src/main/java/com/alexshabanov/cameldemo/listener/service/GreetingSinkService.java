package com.alexshabanov.cameldemo.listener.service;

import com.alexshabanov.cameldemo.domain.Greeting;

import java.util.List;

public interface GreetingSinkService {
    void putGreeting(Greeting greeting);

    List<Greeting> getGreetings();
}