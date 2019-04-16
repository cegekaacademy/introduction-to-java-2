package com.cegeka.academy.util;

import com.cegeka.academy.exception.MaxValueException;
import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class SumCalculator implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if(numberList==null || numberList.size()==0)
            throw new NullListException();
        Number sum=0;
        for(int i=0;i<numberList.size();i++){
            if(Integer.MAX_VALUE<sum.doubleValue()+(double)numberList.get(i))
                throw new MaxValueException();
           sum=sum.doubleValue()+(double)numberList.get(i);
        }
      return sum;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
