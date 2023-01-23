package com.nam.tabling.domain.controller;

import com.nam.tabling.domain.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    public ModelAndView adminPlaces(PlaceType placeType,
                                    String placeName,
                                    String address)
    {
        // @RequestParam을 지정하면 @RequestParam(required = true/false)를 할 수 있다.
        // Optional이라면 굳이 명시하지 않아도 된다.

        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeType);
        map.put("placeName", placeName);
        map.put("address", address);

        return new ModelAndView("admin/places", map);
    }

    @GetMapping("/places/{placeId}") // PathVariable : {}를 변수로 보겠다는 @
    public String adminPlaceDetail(@PathVariable Integer placeId) {
        return "admin/place-detail";
    }

    @GetMapping("/events")
    public String adminEvent() {
        return "admin/event";
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) {
        return "admin/event-detail";
    }
}
