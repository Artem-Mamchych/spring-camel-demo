package com.alexshabanov.cameldemo.greeter.controller;

import com.alexshabanov.cameldemo.domain.Greeting;
import com.alexshabanov.cameldemo.greeter.service.GreeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public final class PublicController {
    private final Logger log = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    private GreeterService greeterService;

    @RequestMapping("/index.html")
    public String index(Model model, @RequestParam(value = "sent", required = false) Boolean sent) {
        if (sent == null) {
            sent = false;
        }

        model.addAttribute("greeting", new Greeting("hello", 20));
        model.addAttribute("sent", sent);
        return "index";
    }

    @RequestMapping(value = "/send.do", method = RequestMethod.POST)
    public String sendGreeting(Greeting greeting) {
        log.info("Sending {}", greeting);
        greeterService.send(greeting);
        return "redirect:index.html?sent=true";
    }
}
