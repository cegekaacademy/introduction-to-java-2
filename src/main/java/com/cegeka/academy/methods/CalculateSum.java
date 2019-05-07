package com.cegeka.academy.methods;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.MaxSumException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.math.BigDecimal;
import java.util.List;

public class CalculateSum implements CalculateService {


    @Override
    public Number calculate(List numberList) {
        if(numberList == null || numberList.size() == 0){
          throw new EmptyNullListException();
        }
        int sum = 0;
        for(int i=0;i<numberList.size();i++){
            sum+=(int)numberList.get(i);
        }
        if(sum>Integer.MAX_VALUE){
            throw new MaxSumException();
        }
        return sum;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
