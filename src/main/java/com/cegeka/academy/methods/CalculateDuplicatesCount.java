package com.cegeka.academy.methods;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.UniqueElementsException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CalculateDuplicatesCount implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        List nonDuplicatedNumbers = new ArrayList();
        int nr=0;
        if(numberList == null || numberList.size() == 0){
            throw new EmptyNullListException();
        }
        for(int i=0;i<numberList.size();i++){
            if(!nonDuplicatedNumbers.contains(numberList.get(i))) {
                nonDuplicatedNumbers.add(numberList.get(i));
            }
        }
        for(int i=0;i<nonDuplicatedNumbers.size();i++){
            if(Collections.frequency(numberList, nonDuplicatedNumbers.get(i))>1){
                nr++;
            }
        }
        if(nr==0 || nonDuplicatedNumbers==null || nonDuplicatedNumbers.size()==0){
            throw new UniqueElementsException();
        }
        return nr;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
