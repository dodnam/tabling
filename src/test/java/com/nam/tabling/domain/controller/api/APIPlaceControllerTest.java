package com.nam.tabling.domain.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {
    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }
}