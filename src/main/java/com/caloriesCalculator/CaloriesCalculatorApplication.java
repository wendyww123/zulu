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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CaloriesCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriesCalculatorApplication.class, args);
	}

	// Initialing the data
//	@Bean
//	CommandLineRunner runner(DataRepository dataRepository,
//							 ActivityRepository activityRepository,
//							 DailyCaloriesBurnedRepository dailyCaloriesBurnedRepository,
//							 MongoTemplate mongoTemplate) {
//		return args->{
//
//			// 1. Find activities on a single day and put it into "Activity" database,
//			// at the same time sum up the calories burned along the process
//			int userId = 1;
//			//20130209
//			String startDateStr = "20130209";
//			String endDateStr = "20170923";
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			Date startDate = sdf.parse(startDateStr);
//			Date endDate = sdf.parse(endDateStr);
//
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(startDate);
//
//			for (Date date = startDate; date.compareTo(endDate) <= 0; ) {
//				String dateStr = sdf.format(date);
//				dataRepository.findDataByDate(dateStr).ifPresent(data -> {
//				System.out.println(data);
//					int caloriesBurned = 0;
//					// activities found
//					List<DBObject> activities = data.getSummary();
//					if (activities != null) {
//						// for loop run through each activity
//						for(DBObject a: activities){
//							ActivityType type = ActivityType.valueOf((String) a.get("activity"));
//							int calories = 0;
//							if (type == ActivityType.transport ||
//									type == ActivityType.airplane ||
//									type == ActivityType.train ||
//									type == ActivityType.ferry ||
//									type == ActivityType.bus) {
//							} else { calories = (int) a.get("calories");};
//							int duration = (int) a.get("duration");
//							int distance = (int) a.get("distance");
//
//							// activity constructor
//							Activity activity = new Activity(
//									dateStr,
//									type,
//									userId,
//									duration,
//									distance,
//									calories
//							);
//							// add up calories to daily caloriesBurned
//							caloriesBurned += calories;
//							// create the activity record in "Activity" database
//							activityRepository.createActivity(activity);
//						}
//
//						// create the daily calories burned record in "DailyCaloriesBurned" database
//						// dailyCaloriesBurned constructor
//						DailyCaloriesBurned dailyCaloriesBurned = new DailyCaloriesBurned(
//								userId,
//								caloriesBurned,
//								dateStr
//						);
//						// create
//						dailyCaloriesBurnedRepository.createDailyCaloriesBurned(dailyCaloriesBurned);
//					}
//				});
//
//				calendar.add(Calendar.DAY_OF_MONTH, 1);
//				date = calendar.getTime();
//			}
//
//
//		};

//	}
}
