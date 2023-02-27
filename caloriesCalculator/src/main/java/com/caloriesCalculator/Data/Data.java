package com.caloriesCalculator.Data;

import com.mongodb.DBObject;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@lombok.Data
@Document
public class Data {
    @Id
    private String id;
    private String date;
    private List<DBObject> summary;
    private List<DBObject> segments;
    private int caloriesIdle;
    private String lastUpdate;

    public Data(String date, List<DBObject> summary, List<DBObject> segments, int caloriesIdle, String lastUpdate) {
        this.date = date;
        this.summary = summary;
        this.segments = segments;
        this.caloriesIdle = caloriesIdle;
        this.lastUpdate = lastUpdate;
    }
}
