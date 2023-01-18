package com.nam.tabling.controller.api;

import com.nam.tabling.constant.EventStatus;
import com.nam.tabling.dto.APIDataResponse;
import com.nam.tabling.dto.EventResponse;
import com.sun.jdi.request.EventRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents() {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2023,1,1,13,0,0),
                LocalDateTime.of(2023,1,1,13,0,0),
                0,
                24,
                "마스크 꼭 착용하세요"
            )));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@RequestBody EventRequest eventRequest) {
        return APIDataResponse.empty();
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Integer eventId) {
        if(eventId.equals(2L)){
            return APIDataResponse.empty();
        }
        return APIDataResponse.empty();
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
