package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.AverageException;
import com.cegeka.academy.exceptions.ListException;

import java.util.List;

public class Average implements CalculateService {
    @Override
    public Number calculate(List numberList) throws ListException, AverageException {
        int average = 0;

        for (Object i:numberList) {
            if(average < 0)
                throw new AverageException("Lista contine numere negative");
            average += (int)i;
        }
        average = average/(numberList.size());
        return average;
    }

    @Override
    public String getStrategy() {
        return "AVG";
    }
}
