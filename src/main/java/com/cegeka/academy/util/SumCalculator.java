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
        Number suma = 0;

        for (int i = 0; i < numberList.size(); i++) {
            if(Integer.MAX_VALUE < suma.doubleValue() + Integer.MAX_VALUE ){
                throw new SumMaxValueException();
            }
            suma = suma.doubleValue() + (double) numberList.get(i);
        }


        return suma;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
