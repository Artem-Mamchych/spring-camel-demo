package com.alexshabanov.cameldemo.greeter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DummyTest.Config.class)
public class DummyTest {

    @Configuration
    public static class Config {
    }

    @Test
    public void shouldDoSomething() {
        assertTrue(true);
    }
}
