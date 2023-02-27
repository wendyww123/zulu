package com.caloriesCalculator.DailyCaloriesBurned;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DailyCaloriesBurnedRepository extends MongoRepository<DailyCaloriesBurned, String> {

    // [C] -> create new "daily calories burned" item in the database
    default void createDailyCaloriesBurned(DailyCaloriesBurned dailyCaloriesBurned) {
        save(dailyCaloriesBurned);
    }

    // [R] -> read/find calories burned by the userId and date from the database
    Optional<DailyCaloriesBurned> findDailyCaloriesBurnedByUserIdAndDate(int userId, String date);
}
