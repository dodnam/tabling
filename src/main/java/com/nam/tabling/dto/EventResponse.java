package com.nam.tabling.dto;

import com.nam.tabling.constant.EventStatus;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public record EventResponse(
        Long placeId,
        String eventName,
        EventStatus eventStatus,
        LocalDateTime eventStartDatetime,
        LocalDateTime eventEndDatetime,
        Integer cuurentNumberOfPeople,
        Integer capacity,
        String memo
) {
    public static EventResponse of(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer cuurentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new EventResponse(
                placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime, cuurentNumberOfPeople, capacity, memo);
    }

    public static EventResponse from(EventDTO eventDTO) {
        if (eventDTO == null) {
            return null;
        }
        return EventResponse.of(
                eventDTO.placeId(),
                eventDTO.eventName(),
                eventDTO.eventStatus(),
                eventDTO.eventStartDatetime(),
                eventDTO.eventEndDatetime(),
                eventDTO.currentNumberOfPeople(),
                eventDTO.capacity(),
                eventDTO.memo()
        );
    }

}
