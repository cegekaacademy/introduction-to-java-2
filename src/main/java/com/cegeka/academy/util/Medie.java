package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class Medie implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if(numberList == null || numberList.size() == 0){
            throw new NullException();
        }

        for(int i=0;i<numberList.size();i++){
            if((double)numberList.get(i) < 0){
                throw new NegativeNumberException();
            }
        }

        return new Suma().calculate(numberList).doubleValue()/numberList.size();
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.AVG);
    }
}
