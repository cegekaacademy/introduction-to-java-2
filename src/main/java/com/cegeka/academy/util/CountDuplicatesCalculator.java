package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.SumMaxValueException;
import com.cegeka.academy.exceptions.UniqueElementException;
import com.cegeka.academy.service.CalculateService;


import java.util.Collections;
import java.util.List;

public class CountDuplicatesCalculator implements CalculateService {

    @Override
    public Number calculate(List numberList) throws EmptyInputException, SumMaxValueException {

        int result = 0;
        for (int i = 0; i < numberList.size(); i++) {
            if(Collections.frequency(numberList,numberList.get(i))>1){
                result ++;
            }

        }
        if(result == 0){
            throw new UniqueElementException();
        }

        return result;
    }

    @Override
    public String getStrategy() {
        return Strategy.COUNT_DUPLICATES.toString();
    }
}
