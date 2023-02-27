package com.caloriesCalculator.CaloriesGoal;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CaloriesGoalRepository extends MongoRepository<CaloriesGoal, String> {

    // [R] -> read the "calories goal" object set by a specific user
    Optional<CaloriesGoal> findCaloriesGoalByUserId(int userId);

    // [U] -> update the "calories goal" object by a specific user
    default void updateCaloriesGoalByUserId(int userId, CaloriesGoal updatedCaloriesGoal) {
        Optional<CaloriesGoal> existingCaloriesGoalOptional = findCaloriesGoalByUserId(userId);
        if (existingCaloriesGoalOptional.isPresent()) {
            CaloriesGoal existingCaloriesGoal = existingCaloriesGoalOptional.get();
            existingCaloriesGoal.setGoal(updatedCaloriesGoal.getGoal());
            save(existingCaloriesGoal);
        }

    }
}
