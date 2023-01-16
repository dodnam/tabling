package com.nam.tabling.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class BaseControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @DisplayName("[view][GET] 기본 페이지 요청") // junit5에서 제공하는 자유로운 이름 표기
    @Test
    void basePageShouldShowIndexPage() throws Exception{
        // given
        // when
        // ResultActions result = mvc.perform(get("/"));
        // then
        // result.andExpect.andExpect....도 가능하지만, 합치니까 좋다.

        // when & then
        mvc.perform(get("/")) // exception을 던진다
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("index.html 입니다."))) // string을 쓰면 문자열을 완전히 체크함
                .andExpect(view().name("index"))
                .andDo(print());
    }
}