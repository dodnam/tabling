package com.nam.tabling.controller.api;

import com.nam.tabling.dto.APIDataResponse;
import org.springframework.web.bind.annotation.GetMapping;

//@RequestMapping("/api")
//@RestController
public class APIAuthController {

    @GetMapping("sign-up")
    public APIDataResponse<String> signUp() {
        return APIDataResponse.empty();
    }

    @GetMapping("login")
    public APIDataResponse<String> login() {
        return APIDataResponse.empty();
    }
}
