package com.cegeka.academy.classes;

import com.cegeka.academy.exceptions.SumaException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class MathSum implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new SumaException("Lista nu este corecta! Null sau goala!");
        }

        Integer result = 0;

        for (Object n : numberList) {
            if (result >= Integer.MAX_VALUE) {
                throw new SumaException("Suma prea mare!");
            }
            result += (Integer) n;
        }

        return result;
    }

    @Override
    public String getStrategy() {
        return Strategy.SUM.toString();
    }
}
