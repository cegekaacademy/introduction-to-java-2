package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.SumMaxValueException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class SumCalculator implements CalculateService {

    @Override
    public  Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new EmptyInputException();
        }
        Number sum = 0;

        for (int i = 0; i < numberList.size(); i++) {
            if(Double.MAX_VALUE - sum.doubleValue() < (double)numberList.get(i)){
                throw new SumMaxValueException();
            }
            sum = sum.doubleValue() + (double) numberList.get(i);
        }


        return sum;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
