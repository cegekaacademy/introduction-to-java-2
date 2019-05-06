package com.cegeka.academy.util;

import com.cegeka.academy.exception.Exceptie;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class CalculateAvg implements CalculateService<Integer> {
    @Override
    public Integer calculate(List<? extends Number> numberList) throws Exceptie {
        if(numberList.size()==0||numberList==null)
        {
            throw new Exceptie();
        }
        Integer rez=0;
        for(Object n:numberList)
        {   if(rez+(Integer)n>Integer.MAX_VALUE)
        {
            throw new Exceptie();
        }
            rez+=(Integer)n;
        }
        return rez/numberList.size();
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.AVG);
    }
}
