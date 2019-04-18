package com.cegeka.academy.classes;

import com.cegeka.academy.exceptions.MedieException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class MathArithmeticAverage implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new MedieException("Lista nu este corecta! Null sau goala!");
        }

        Double result = 0d;

        for (Object obj: numberList) {
            if (obj == null || (Double) obj <= 0) {
                throw new MedieException("Elementele nu pot fi negative!");
            }
            result += (Double) obj;
        }
        result /= numberList.size();

        return result;
    }

    @Override
    public String getStrategy() {
        return Strategy.AVG.toString();
    }
}
