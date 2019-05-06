package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.EmptyListException;
import com.cegeka.academy.exceptions.MAX_INT_Exception;
import com.cegeka.academy.exceptions.NullListException;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class CalculateSum implements CalculateService<Integer>{
    @Override
    public Integer calculate(List numberList) throws NullListException, EmptyListException, MAX_INT_Exception {
        if (numberList== null)
            throw new NullListException("Null list.");
        if (numberList.isEmpty())
            throw new EmptyListException("Empty list.");
        Integer sum = 0;
        for (Object number: numberList){
           if ((sum+ (Integer) number)> Integer.MAX_VALUE)
               throw new MAX_INT_Exception("Sum greater than MAX_INT.");
            sum = sum+ (Integer) number;



       }
        return sum;
    }

    @Override
    public String getStrategy() {
        return Strategy.SUM.toString();
    }
}
