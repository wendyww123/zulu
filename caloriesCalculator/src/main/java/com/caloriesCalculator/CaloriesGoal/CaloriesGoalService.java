package com.caloriesCalculator.CaloriesGoal;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CaloriesGoalService {

    private final CaloriesGoalRepository caloriesGoalRepository;

    public void createGoal(CaloriesGoal caloriesGoal){ caloriesGoalRepository.createCaloriesGoal(caloriesGoal);}
    public int getGoalByUserId(int userId) {
        CaloriesGoal existingCaloriesGoal = caloriesGoalRepository.findCaloriesGoalByUserId(userId);
        if (existingCaloriesGoal != null) {
            return existingCaloriesGoal.getGoal();
        } else {return 0;}
    }

    public void updateGoalByUserId(int userId, int goal){
//        CaloriesGoal updatedCaloriesGoal = new CaloriesGoal(userId, goal);
        CaloriesGoal existingCaloriesGoal = caloriesGoalRepository.findCaloriesGoalByUserId(userId);

        if (existingCaloriesGoal != null){
            Update update = new Update().set("goal", goal);
            caloriesGoalRepository.findAndModifyByUserId(existingCaloriesGoal.getUserId(), update);

        }
    }
}
