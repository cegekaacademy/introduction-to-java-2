package com.cegeka.academy.util;

import com.cegeka.academy.exception.Exceptie;
import com.cegeka.academy.service.CalculateService;

import java.util.LinkedHashSet;
import java.util.List;

public class CalculateDuplicate implements CalculateService<Integer> {
    @Override
    public Integer calculate(List<? extends Number> numberList) throws Exceptie {
        if(numberList==null||numberList.size()==0)
        {
            throw new Exceptie();
        }
        LinkedHashSet<Number> hashSet = new LinkedHashSet<>();
        hashSet.addAll(numberList);
        return  numberList.size()-hashSet.size();
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
