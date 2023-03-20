package com.caloriesCalculator.CaloriesGoal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CaloriesGoal {
    @Indexed(unique = true)
    private int userId;
    private int goal;

    public CaloriesGoal(int userId, int goal) {
        this.userId = userId;
        this.goal = goal;
    }
}
