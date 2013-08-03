package com.alexshabanov.cameldemo.listener.service.support;

import com.alexshabanov.cameldemo.domain.Greeting;
import com.alexshabanov.cameldemo.listener.service.GreetingSinkService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("greetingSinkService")
public final class GreetingSinkServiceImpl implements GreetingSinkService {
    private final List<Greeting> greetings = new CopyOnWriteArrayList<>();

    @Override
    public void putGreeting(Greeting greeting) {
        greetings.add(0, greeting);
    }

    @Override
    public List<Greeting> getGreetings() {
        return Collections.unmodifiableList(Arrays.asList(greetings.toArray(new Greeting[greetings.size()])));
    }
}