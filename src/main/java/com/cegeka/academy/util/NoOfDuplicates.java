package com.cegeka.academy.util;

import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.exception.UniqueElementListException;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoOfDuplicates implements CalculateService {

    @Override
    public Number calculate(List numberList) {
        List nonDuplicatedValues=new ArrayList();
        int nr=0;
        if(numberList==null || numberList.size()==0)
            throw new NullListException();
        for(int i=0;i<numberList.size();i++)
          if(!nonDuplicatedValues.contains(numberList.get(i)))
        nonDuplicatedValues.add(numberList.get(i));

        for(int i=0;i<nonDuplicatedValues.size();i++)
        if(Collections.frequency(numberList,nonDuplicatedValues.get(i))>1){
            nr++;
        }
        if(nonDuplicatedValues.size()==nr)
        throw new UniqueElementListException();
        return nr;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
