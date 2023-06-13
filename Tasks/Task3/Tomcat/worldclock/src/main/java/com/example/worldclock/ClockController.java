package com.example.worldclock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ClockController {

    @GetMapping("/time")
    public String getTime(Model model) {
        Map<String, String> times = new LinkedHashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        times.put("New York", getZonedDateTime("America/New_York").format(formatter));
        times.put("London", getZonedDateTime("Europe/London").format(formatter));
        times.put("Paris", getZonedDateTime("Europe/Paris").format(formatter));
        times.put("Berlin", getZonedDateTime("Europe/Berlin").format(formatter));
        times.put("Tokyo", getZonedDateTime("Asia/Tokyo").format(formatter));
        times.put("Sydney", getZonedDateTime("Australia/Sydney").format(formatter));
        times.put("Moscow", getZonedDateTime("Europe/Moscow").format(formatter));
        times.put("Dubai", getZonedDateTime("Asia/Dubai").format(formatter));
        times.put("New Delhi", getZonedDateTime("Asia/Kolkata").format(formatter));
        times.put("Beijing", getZonedDateTime("Asia/Shanghai").format(formatter));
        times.put("Johannesburg", getZonedDateTime("Africa/Johannesburg").format(formatter));
        times.put("Rio de Janeiro", getZonedDateTime("America/Sao_Paulo").format(formatter));
        times.put("Mexico City", getZonedDateTime("America/Mexico_City").format(formatter));
        times.put("Los Angeles", getZonedDateTime("America/Los_Angeles").format(formatter));
        times.put("Toronto", getZonedDateTime("America/Toronto").format(formatter));

        model.addAttribute("times", times);
        return "time";
    }

    private ZonedDateTime getZonedDateTime(String zoneId) {
        return ZonedDateTime.now(ZoneId.of(zoneId));
    }
}