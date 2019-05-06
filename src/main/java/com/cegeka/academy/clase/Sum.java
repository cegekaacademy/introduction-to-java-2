package com.cegeka.academy.clase;

import com.cegeka.academy.exceptions.SumException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class Sum implements CalculateService {

    @Override
    public Number calculate(List numberList) {
        int sum=0;

        if( numberList==null || numberList.size()==0) {
            throw new SumException();
        }


        for(Object obj:numberList)
        {
            sum+=(Integer)obj;
        }

        return sum;
    }

    @Override
    public String getStrategy() {
        return null;
    }


}
