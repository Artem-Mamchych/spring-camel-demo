package com.alexshabanov.cameldemo.listener.controller;

import com.alexshabanov.cameldemo.listener.service.GreetingSinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public final class PublicController {
    @Autowired
    private GreetingSinkService greetingSinkService;

    @RequestMapping("/index.html")
    public ModelAndView index() {
        return new ModelAndView("index", "greetings", greetingSinkService.getGreetings());
    }
}
