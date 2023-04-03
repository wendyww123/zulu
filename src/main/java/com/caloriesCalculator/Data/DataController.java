package com.caloriesCalculator.Data;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/data")
@AllArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping
    public List<Data> fetchAllData() {
        return dataService.getAllData();
    }

    @GetMapping(path = "/getDataByDate")
    public Optional<Data> fetchDataByDate(@RequestParam("date") String date) {
        return dataService.getDataByDate(date);
    }
}
