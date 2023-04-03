package com.caloriesCalculator.Data;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DataService {

    private final DataRepository dataRepository;

    // [R] - search all data objects
    public List<Data> getAllData(){
        return dataRepository.findAll();
    }

    // [R] - search the data by date
    public Optional<Data> getDataByDate(String date){
       return dataRepository.findDataByDate(date);
   }

}
