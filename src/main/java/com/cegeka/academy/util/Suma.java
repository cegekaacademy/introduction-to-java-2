package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.MaxValueException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class Suma implements CalculateService {

    @Override
    public Number calculate(List numberList)  {
        if (numberList == null || numberList.size()==0){
            throw new NullException();
        }
        int suma = 0;
        for(int i =0;i<numberList.size();i++){
            suma += (int)numberList.get(i);
            if(suma>Integer.MAX_VALUE){
                throw new MaxValueException();
            }

        }
        return suma;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.SUM);
    }
}
