package com.caloriesCalculator.CaloriesGoal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CaloriesGoal {
    @Id
    private String id;
    private int userId;
    private int goal;

    public CaloriesGoal(int userId) {
        this.userId = userId;
        // default goal is set to be 500
        this.goal = 500;
    }
}
