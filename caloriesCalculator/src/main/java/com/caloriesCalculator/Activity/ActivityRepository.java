package com.caloriesCalculator.Activity;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {

    // [C] - create a new activity
    default Activity createActivity(Activity activity){
        return save(activity);
    };

    // [R] - find all activities by userId and date
    List<Activity> findActivitiesByUserIdAndDate(int userId, String date);

    // [D] - delete by object id

}
