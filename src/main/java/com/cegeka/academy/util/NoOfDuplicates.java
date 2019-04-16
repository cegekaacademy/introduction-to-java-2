package com.cegeka.academy.util;

import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.exception.UniqueElementListException;
import com.cegeka.academy.service.CalculateService;

import java.util.Collections;
import java.util.List;

public class NoOfDuplicates implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        int nr=0;
        if(numberList==null || numberList.size()==0)
            throw new NullListException();
        for(int i=0;i<numberList.size();i++)
        if(Collections.frequency(numberList,numberList.get(i))>1){
            nr++;
        }
        if(nr==0)
        throw new UniqueElementListException();
        return nr;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
