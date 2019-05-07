package com.cegeka.academy.methods;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.MaxSumException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.List;

public class CalculateAverage implements CalculateService {


    @Override
    public Number calculate(List numberList) {
        if(numberList == null || numberList.size() ==0){
            throw new EmptyNullListException();
        }
        int sum=0;
        for(int i=0;i<numberList.size();i++){
            if((int)numberList.get(i)<0){
                throw new NegativeArraySizeException();
            }
        }
        return new CalculateSum().calculate(numberList).intValue()/numberList.size();
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.AVG);
    }
}
