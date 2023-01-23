package com.nam.tabling.repository;

import com.nam.tabling.domain.Event;
import com.nam.tabling.domain.Place;
import com.nam.tabling.domain.QEvent;
import com.nam.tabling.repository.querydsl.EventRepositoryCustom;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Optional;

// TODO : 인스턴스 생성 편의를 위한 임시 default, repository layer 완전히 구현하면 삭제 필요
public interface EventRepository extends
        JpaRepository<Event, Long>,
        EventRepositoryCustom,
        QuerydslPredicateExecutor<Event>,
        QuerydslBinderCustomizer<QEvent> {

    Page<Event> findByPlace(Place place, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QEvent root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.place.placeName, root.eventName, root.eventStatus, root.eventStartDatetime, root.eventEndDatetime);
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
