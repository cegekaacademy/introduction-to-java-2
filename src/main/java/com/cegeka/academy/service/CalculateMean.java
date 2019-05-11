package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.util.Strategy;
import com.cegeka.academy.exceptions.NegativeNumberException;

import java.util.List;

public class CalculateMean implements CalculateService<Float> {
    @Override
    public Float calculate(List<? extends Number> numberList) throws ListBoundaryException, NegativeNumberException {
        if (numberList == null || numberList.isEmpty())
            throw new ListBoundaryException();
        Float mean = 0F;
        for (Object number : numberList)
            if ((Integer) number < 0)
                throw new NegativeNumberException();
            else
                mean += (Integer) number;

        return mean / numberList.size();

    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.AVG);
    }
}
