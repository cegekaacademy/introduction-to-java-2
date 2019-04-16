package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.SumMaxValueException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class AverageCalculator implements CalculateService {

    @Override
    public Number calculate(List numberList) throws EmptyInputException, SumMaxValueException {
        if (numberList == null || numberList.size() == 0) {
            throw new EmptyInputException();
        }
        for (int i = 0; i < numberList.size(); i++) {
            if((double)numberList.get(i)<0){
               throw new NegativeNumberException();
            }
        }

        return new SumCalculator().calculate(numberList).doubleValue()/numberList.size();
    }

    @Override
    public String getStrategy() {
        return Strategy.AVG.toString();
    }
}
