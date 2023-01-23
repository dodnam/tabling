package com.nam.tabling.domain.repository;

import com.nam.tabling.domain.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Optional;

// TODO : 인스턴스 생성 편의를 위한 임시 default, repository layer 완전히 구현하면 삭제 필요
public interface EventRepository extends
        JpaRepository<Event, Long>,
        QuerydslPredicateExecutor<Event>,
        QuerydslBinderCustomizer<QEvent> {

    Optional<Event> findByPlaceIdAndEventNameAndCapacity();

    @Override
    default void customize(QuerydslBindings bindings, QEvent root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.placeId, root.eventName, root.eventStatus, root.eventStartDatetime, root.eventEndDatetime);
        bindings.bind(root.eventName).first(StringExpression::likeIgnoreCase);
        bindings.bind(root.eventStartDatetime).first(ComparableExpression::goe);
        bindings.bind(root.eventEndDatetime).first(ComparableExpression::loe);
        }

//    default Optional<EventDTO> findEvent(Long eventIO) {
//        return Optional.empty();
//    }
//    default boolean insertEvent(EventDTO eventDTO) {
//        return false;
//    }
//    default boolean updateEvent(Long eventId, EventDTO dto) {
//        return false;
//    }
//    default boolean deleteEvent(Long eventId) {
//        return false;
//    }
}
