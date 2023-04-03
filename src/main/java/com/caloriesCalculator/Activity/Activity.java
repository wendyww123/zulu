package com.caloriesCalculator.Activity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Activity {
    @Id
    private String id;
    private String date;
    private ActivityType type;
    private int userId;
    private int duration;
    private int distance;
    private int calories;

    public Activity(String date, ActivityType type, int userId, int duration, int distance, int calories) {
        this.date = date;
        this.type = type;
        this.userId = userId;
        this.duration = duration;
        this.distance = distance;
        this.calories = calories;
    }
}
