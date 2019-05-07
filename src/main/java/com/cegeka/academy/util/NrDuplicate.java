package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NrDuplicate implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        List nonDuplicatedValues=new ArrayList();
        int nr=0;
        if(numberList==null || numberList.size()==0)
            throw new NullException();
        for(int i=0;i<numberList.size();i++)
            if(!nonDuplicatedValues.contains(numberList.get(i)))
                nonDuplicatedValues.add(numberList.get(i));

        for(int i=0;i<nonDuplicatedValues.size();i++)
            if(Collections.frequency(numberList,nonDuplicatedValues.get(i))>1){
                nr++;
            }
        if(nonDuplicatedValues.size()==nr || nr==0)
            throw new DuplicateException();
        return nr;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
