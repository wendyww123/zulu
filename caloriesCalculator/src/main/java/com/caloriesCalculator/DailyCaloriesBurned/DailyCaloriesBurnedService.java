package com.caloriesCalculator.DailyCaloriesBurned;

import com.caloriesCalculator.Activity.Activity;
import com.caloriesCalculator.Activity.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DailyCaloriesBurnedService {
    private final DailyCaloriesBurnedRepository dailyCaloriesBurnedRepository;
    private final ActivityRepository activityRepository;

    // [R] - search all dailyCaloriesBurned objects
    public List<DailyCaloriesBurned> getAllDailyCaloriesBurned(){
        return dailyCaloriesBurnedRepository.findAll();
    }

    // [R] - search calories burned by DATE and USERID
    public int getDailyCaloriesBurnedByUserIdAndDate(int userId, String date) {
        return dailyCaloriesBurnedRepository.findDailyCaloriesBurnedByUserIdAndDate(userId, date).getCaloriesBurned();
    }

    // [U] - update daily calories by userId and date
    public void UpdateDailyCaloriesBurnedByUserIdAndDate(int userId, String date){
        List<Activity> activities = activityRepository.findActivitiesByUserIdAndDate(userId, date);
        int calories = 0;
        for (Activity activity:activities){
            calories += activity.getCalories();
        }
        DailyCaloriesBurned existingDailyCaloriesBurned = dailyCaloriesBurnedRepository.findDailyCaloriesBurnedByUserIdAndDate(userId, date);

        if (existingDailyCaloriesBurned != null){
            Update update = new Update().set("caloriesBurned", calories);
            dailyCaloriesBurnedRepository.findAndModifyByUserIdAndDate(existingDailyCaloriesBurned.getUserId(), existingDailyCaloriesBurned.getDate(), update);
        } else {
            DailyCaloriesBurned dailyCaloriesBurned = new DailyCaloriesBurned(userId, calories, date);
            dailyCaloriesBurnedRepository.save(dailyCaloriesBurned);
        }
    }
}
