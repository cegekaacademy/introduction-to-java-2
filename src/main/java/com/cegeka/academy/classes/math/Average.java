package com.cegeka.academy.classes.math;

import com.cegeka.academy.exceptions.AverageException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class Average implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new AverageException("Lista nu este corecta! Null sau goala!");
        }

        Double result = 0d;

        for (Object obj : numberList) {
            Double val = (Double) obj;
            if (val <= 0) {
                throw new AverageException("Elementele nu pot fi negative!");
            }
            result += val;
        }
        result /= numberList.size();

        return result;
    }

    @Override
    public String getStrategy() {
        return Strategy.AVG.toString();
    }
}
