package com.caloriesCalculator.Activity;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {

    // [C] - create activity
    default void createActivity(Activity activity){
        save(activity);
    };

    // [R] - find all activities with same date
    List<Activity> findActivitiesByDate(String date);
}
