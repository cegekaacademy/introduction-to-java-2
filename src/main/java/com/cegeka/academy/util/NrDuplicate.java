package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.service.CalculateService;

import java.util.Collections;
import java.util.List;

public class NrDuplicate implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if(numberList == null || numberList.size()==0){
            throw new NegativeNumberException();
        }
        int nr=0;
        int suma = 0;
        for(int i=0;i<numberList.size();i++){
            if(Collections.frequency(numberList, numberList.get(i))>1){
                nr++;
                suma += Collections.frequency(numberList, numberList.get(i));
            }
        }
        if(nr == 0 || suma == numberList.size()){
            throw new DuplicateException();
        }
        return nr;
    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
