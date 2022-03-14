package com.chegg.school.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class DefaultController {

    /**
     * Default path for this server.
     */
    @GetMapping("/")
    public String landingPage() {
        return "index";
    }
}
