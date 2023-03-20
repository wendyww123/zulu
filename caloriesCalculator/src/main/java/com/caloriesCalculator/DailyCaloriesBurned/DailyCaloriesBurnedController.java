package com.caloriesCalculator.DailyCaloriesBurned;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/dailyCaloriesBurned")
@AllArgsConstructor
public class DailyCaloriesBurnedController {

    private final DailyCaloriesBurnedService dailyCaloriesBurnedService;

    @GetMapping
    public List<DailyCaloriesBurned> fetchAllDailyCaloriesBurned() {
        return dailyCaloriesBurnedService.getAllDailyCaloriesBurned();
    }

    @GetMapping(path = "/getCaloriesBurned")
    public int fetchDailyCaloriesBurnedByUserIdAndDate(@RequestParam("userId") int userId, @RequestParam("date") String date) {
//        int intUserId = Integer.parseInt(userId);
        return dailyCaloriesBurnedService.getDailyCaloriesBurnedByUserIdAndDate(userId, date);
    }
}
