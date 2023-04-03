package com.caloriesCalculator.Activity;

import com.caloriesCalculator.DailyCaloriesBurned.DailyCaloriesBurnedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/activities")
@AllArgsConstructor
public class ActivityController {

    private final ActivityService activityService;
    private final DailyCaloriesBurnedService dailyCaloriesBurnedService;

    @PostMapping
    public void createActivity(@RequestBody Activity activity){
        activityService.createActivity(activity);

        // also need to recalculate the daily calories burned
        String date = activity.getDate();
        int userId = activity.getUserId();
        dailyCaloriesBurnedService.UpdateDailyCaloriesBurnedByUserIdAndDate(userId, date);
    }

    @GetMapping
    public List<Activity> fetchActivitiesByUserIdAndDate(@RequestParam("userId") int userId, @RequestParam("date") String date){
        return activityService.getActivitiesByUserIdAndDate(userId, date);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") String id, @RequestBody Activity updatedActivity) {
        Activity existingActivity = activityService.getById(id);
        String oldDate = existingActivity.getDate();

        // set the object activity to be updated
        existingActivity.setDate(updatedActivity.getDate());
        existingActivity.setType(updatedActivity.getType());
        existingActivity.setDuration(updatedActivity.getDuration());
        existingActivity.setDistance(updatedActivity.getDistance());
        existingActivity.setCalories(updatedActivity.getCalories());

        // save
        final Activity activity = activityService.createActivity(existingActivity);

        // Also need to recalculate the daily calories burned since they could be modified
        String newDate = updatedActivity.getDate();
        dailyCaloriesBurnedService.UpdateDailyCaloriesBurnedByUserIdAndDate(existingActivity.getUserId(), oldDate);
        dailyCaloriesBurnedService.UpdateDailyCaloriesBurnedByUserIdAndDate(existingActivity.getUserId(), newDate);

        return ResponseEntity.ok(activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivityById(@PathVariable("id") String id){
        Activity activity = activityService.getById(id);
        String date = activity.getDate();
        int userId = activity.getUserId();
        activityService.deleteActivityById(id);

        // Also need to recalculate the daily calories burned because of the activity deletion
        dailyCaloriesBurnedService.UpdateDailyCaloriesBurnedByUserIdAndDate(userId, date);

    }
}
