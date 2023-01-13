package com.nam.tabling.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice(basePackageClasses = BaseController.class) // BaseController가 속해있는 패키지가 범위임을 의미함
@Controller // Controller bean으로 스프링에 등록된다.
public class BaseController implements ErrorController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
