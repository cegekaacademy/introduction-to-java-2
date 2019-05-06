package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.EmptyListException;
import com.cegeka.academy.exceptions.MAX_INT_Exception;
import com.cegeka.academy.exceptions.NegativeNumbersException;
import com.cegeka.academy.exceptions.NullListException;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class CalculateAvg implements CalculateService<Integer> {
    @Override
    public Integer calculate(List numberList) throws NullListException, EmptyListException, NegativeNumbersException {
        if (numberList== null)
            throw new NullListException("Null list.");
        if (numberList.isEmpty())
            throw new EmptyListException("Empty list.");
        Integer sum = 0;
        Integer listSize = numberList.size();
        for (Object number: numberList){
            if ((Integer) number < 0)
                throw new NegativeNumbersException("Negative numbers.");
            sum = sum+ (Integer) number;



        }
        return sum/listSize;
    }

    @Override
    public String getStrategy() {
        return Strategy.AVG.toString();
    }
}
