package com.caloriesCalculator.CaloriesGoal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Optional;

public interface CaloriesGoalRepository extends MongoRepository<CaloriesGoal, String> {

    // [C] -> (only for testing now) create a new calories' goal for specific user
    default void createCaloriesGoal(CaloriesGoal caloriesGoal){
        save(caloriesGoal);
    }

    // [R] -> read the "calories goal" object set by a specific user
    CaloriesGoal findCaloriesGoalByUserId(int userId);

    // [U] -> update the "calories goal" object by a specific user　(output: number of document modified)
    int findAndModifyByUserId(int userId, Update update);
}
