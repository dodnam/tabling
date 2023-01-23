package com.nam.tabling.domain.controller.api;

import com.nam.tabling.domain.constant.EventStatus;
import com.nam.tabling.domain.dto.APIDataResponse;
import com.nam.tabling.domain.dto.EventResponse;
import com.nam.tabling.domain.service.EventService;
import com.sun.jdi.request.EventRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
//@Validated
@RequiredArgsConstructor

//@RequestMapping("/api")
//@RestController
public class APIEventController {

    private EventService eventService;

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents(
            @Positive Long placeId,
            @Size(min = 2) String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    ) {
        List<EventResponse> response = eventService
                .getEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime)
                .stream().map(EventResponse::from).toList();


        return APIDataResponse.of(response);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@Valid @RequestBody EventRequest eventRequest) {
        log.debug("보고 싶은 값 : {}", eventRequest);
        //        boolean result = eventService.createEvent(eventRequest.toDTO());
        return APIDataResponse.empty();
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Integer eventId) {
        if(eventId.equals(2L)){
            return APIDataResponse.empty();
        }
        return APIDataResponse.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2023,1,1,13,0,0),
                LocalDateTime.of(2023,1,1,13,0,0),
                0,
                24,
                "마스크 꼭 착용하세요"
        ));
    }

    @PutMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable Integer eventId) {
        return true;
    }

    @DeleteMapping("events/{eventId}")
    public Boolean removeEvent(@PathVariable Integer eventId) {
        return true;
    }
}
