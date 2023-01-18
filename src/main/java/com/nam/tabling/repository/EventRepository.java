package com.nam.tabling.repository;

import com.nam.tabling.constant.EventStatus;
import com.nam.tabling.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// TODO : 인스턴스 생성 편의를 위한 임시 default, repository layer 완전히 구현하면 삭제 필요
public interface EventRepository {
    default List<EventDTO> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) { return null; }
    default Optional<EventDTO> findEvent(Long eventIO) {
        return Optional.empty();
    }
    default boolean insertEvent(EventDTO eventDTO) {
        return false;
    }
    default boolean updateEvent(Long eventId, EventDTO dto) {
        return false;
    }
    default boolean deleteEvent(Long eventId) {
        return false;
    }
}
