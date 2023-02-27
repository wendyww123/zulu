package com.caloriesCalculator.DailyCaloriesBurned;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DailyCaloriesBurned {
    @Id
    private String id;
    private int userId;
    private int caloriesBurned;
    private String date;

    public DailyCaloriesBurned(int userId, int caloriesBurned, String date) {
        this.userId = userId;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }
}
