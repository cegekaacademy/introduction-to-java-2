package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.ListException;
import com.cegeka.academy.exceptions.SumException;

import java.util.List;

public class Sum implements CalculateService  {
    @Override
    public Number calculate(List numberList) throws ListException, SumException {

            if (numberList == null || numberList.isEmpty()) {
                throw new ListException("The list doesn't exist");
            }
            int sum = 0;
            for (Object i : numberList) {
                sum += (int) i;
            }

            if(sum >= Integer.MAX_VALUE)
                throw  new SumException("Suma depaseste valoarea maxima");

            return sum;

    }

    @Override
    public String getStrategy() {
        return "SUM";
    }
}
