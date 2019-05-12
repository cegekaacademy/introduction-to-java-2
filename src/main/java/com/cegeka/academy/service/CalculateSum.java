package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.exceptions.UpperBoundaryException;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class CalculateSum implements CalculateService<Integer> {
    @Override
    public Integer calculate(List numberList) throws ListBoundaryException, UpperBoundaryException {
        if (numberList == null || numberList.isEmpty())
            throw new ListBoundaryException();
        Integer sum = 0;
        for (Object number : numberList) {
            sum += (Integer) number;
            if (sum >= Integer.MAX_VALUE)
                throw new UpperBoundaryException();
        }
        return sum;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
