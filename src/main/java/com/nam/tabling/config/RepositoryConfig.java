package com.nam.tabling.config;

import com.nam.tabling.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 구현체를 bean으로 등록
public class RepositoryConfig {

    @Bean
    public EventRepository eventRepository() {
        return new EventRepository() {
        };
    }
}
