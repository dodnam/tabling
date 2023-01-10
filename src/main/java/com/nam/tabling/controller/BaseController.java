package com.nam.tabling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller bean으로 스프링에 등록된다.
public class BaseController {

    @GetMapping("/")
    public String root() {
        return "index";
    }
}
