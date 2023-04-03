package com.caloriesCalculator.Activity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.createActivity(activity);}

    public Activity getById(String id){
        return activityRepository.findById(id).get();
    }

    public List<Activity> getActivitiesByUserIdAndDate(int userId, String date){
        return activityRepository.findActivitiesByUserIdAndDate(userId, date);
    }

    public void deleteActivityById(String id){
        activityRepository.deleteById(id);
    }


}
