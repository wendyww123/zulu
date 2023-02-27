package com.caloriesCalculator;

import com.caloriesCalculator.Activity.Activity;
import com.caloriesCalculator.Activity.ActivityRepository;
import com.caloriesCalculator.Activity.ActivityType;
import com.caloriesCalculator.DailyCaloriesBurned.DailyCaloriesBurned;
import com.caloriesCalculator.DailyCaloriesBurned.DailyCaloriesBurnedRepository;
import com.caloriesCalculator.Data.DataRepository;
import com.mongodb.DBObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
public class CaloriesCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriesCalculatorApplication.class, args);
	}

	// [R] - Read from Data
	@Bean
	CommandLineRunner runner(DataRepository dataRepository,
							 ActivityRepository activityRepository,
							 DailyCaloriesBurnedRepository dailyCaloriesBurnedRepository,
							 MongoTemplate mongoTemplate) {
		return args->{

			// 1. Find activities on a single day and put it into "Activity" database,
			// at the same time sum up the calories burned along the process
			String date = "20130216";
			int userId = 1;
			dataRepository.findDataByDate(date).ifPresent(data -> {
				System.out.println(data);
				int caloriesBurned = 0;
				// activities found
				List<DBObject> activities = data.getSummary();
				// for loop run through each activity
				for(DBObject a: activities){
					ActivityType type = ActivityType.valueOf((String) a.get("activity"));
					if (type == ActivityType.transport) continue;
					int duration = (int) a.get("duration");
					int distance = (int) a.get("distance");
					int calories = (int) a.get("calories");

					// activity constructor
					Activity activity = new Activity(
							date,
							type,
							userId,
							duration,
							distance,
							calories
					);
					// add up calories to daily caloriesBurned
					caloriesBurned += calories;
					// create the activity record in "Activity" database
					activityRepository.createActivity(activity);
				}

				// create the daily calories burned record in "DailyCaloriesBurned" database
				// dailyCaloriesBurned constructor
				DailyCaloriesBurned dailyCaloriesBurned = new DailyCaloriesBurned(
						userId,
						caloriesBurned,
						date
				);
				// create
				dailyCaloriesBurnedRepository.createDailyCaloriesBurned(dailyCaloriesBurned);
			});

		};


	}
}
