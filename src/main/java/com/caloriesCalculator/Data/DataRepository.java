package com.caloriesCalculator.Data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DataRepository extends MongoRepository<Data, String> {

    // [R] - search the data by date
    Optional<Data> findDataByDate(String date);

    // [R] - search all data objects
}
