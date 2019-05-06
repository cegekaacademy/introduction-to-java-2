package com.cegeka.academy.classes;

import com.cegeka.academy.service.CalculateService;

import java.util.HashSet;
import java.util.List;

public class CountDuplicates implements CalculateService{

    @Override
    public Number calculate(List numberList) throws Exception {
        HashSet<Number> set = new HashSet<>();
        set.addAll(numberList);

        int numberOfDuplicates = set.size()-numberList.size();

        if(numberOfDuplicates == 0){
            throw new Exception("Lista nu contine duplicate");
        }
        else {
            return numberOfDuplicates;
        }
    }

    @Override
    public String getStrategy() {
        return "COUNT_DUPLICATES";
    }
}
