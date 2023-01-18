package com.nam.tabling.dto;

import com.nam.tabling.constant.EventStatus;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class EventResponse<T> {

    public static <T> EventResponse<T> of(Long a, String b, EventStatus c,
                                          LocalDateTime d, LocalDateTime e, Integer f,
                                          Integer g, String h) {
        return new EventResponse();
    }


}
