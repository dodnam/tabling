package com.nam.tabling.domain.controller.error;

import com.nam.tabling.config.SecurityConfig;
import com.nam.tabling.controller.error.BaseErrorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View 컨트롤러 - 에러")
@WebMvcTest(controllers = BaseErrorController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class))
class BaseErrorControllerTest {
    private final MockMvc mvc;

    public BaseErrorControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 에러 페이지 - 없음") // junit5에서 제공하는 자유로운 이름 표기
    @Test
    void givenWrongURI_whenRequestingPage_thenReturns404Error() throws Exception{
        // given

        // when & then
        mvc.perform(get("/wrong-rui")) // exception을 던진다
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}