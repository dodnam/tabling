package com.nam.tabling.domain.controller;

import com.nam.tabling.config.SecurityConfig;
import com.nam.tabling.controller.BaseController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@AutoConfigureMockMvc
//@SpringBootTest
@DisplayName("View 컨트롤러 - 기본 페이지")
@WebMvcTest(
        controllers = BaseController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)) // ()안에 대상 컨트롤러를 담거나, 안 담으면 모든 컨트롤러를 test한다.
class BaseControllerTest {

    private final MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }
    
    @DisplayName("[view][GET] 기본 페이지 요청") // junit5에서 제공하는 자유로운 이름 표기
    @Test
    void givenNothing_whenRequestingRootPage_thenReturnsIndexPage() throws Exception{
        // given
        // when
        // ResultActions result = mvc.perform(get("/"));
        // then
        // result.andExpect.andExpect....도 가능하지만, 합치니까 좋다.

        // when & then
        mvc.perform(get("/"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/events"))
                .andExpect(view().name("redirect:/events"));
    }
}