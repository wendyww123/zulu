package com.caloriesCalculator.CaloriesGoal;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/goal")
@AllArgsConstructor
public class CaloriesGoalController {

    private final CaloriesGoalService caloriesGoalService;

    @PostMapping
    public void createGoal(@RequestBody CaloriesGoal caloriesGoal){
        caloriesGoalService.createGoal(caloriesGoal);
    }

    @GetMapping
    public int fetchGoalByUserId(@RequestParam("userId") int userId) {
        return caloriesGoalService.getGoalByUserId(userId);
    }

    @PutMapping
    public void adjustGoalByUserId(@RequestParam("userId") int userId, @RequestBody int goal) {
        caloriesGoalService.updateGoalByUserId(userId, goal);
    }
}
