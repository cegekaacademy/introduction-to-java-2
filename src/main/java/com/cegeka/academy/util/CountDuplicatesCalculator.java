package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.SumMaxValueException;
import com.cegeka.academy.exceptions.UniqueElementException;
import com.cegeka.academy.service.CalculateService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountDuplicatesCalculator implements CalculateService {

    @Override
    public Number calculate(List numberList) throws EmptyInputException, SumMaxValueException {

        boolean findUniqueElement = false;
        if (numberList == null || numberList.size() == 0) {
            throw new EmptyInputException();
        }

        List noDuplicates = new ArrayList();
        for (int i = 0; i < numberList.size() ; i++) {
            if(!noDuplicates.contains(numberList.get(i))){
                noDuplicates.add(numberList.get(i));
            }
        }
        int result = 0;
        for (int i = 0; i < noDuplicates.size(); i++) {
            if(Collections.frequency(numberList,noDuplicates.get(i))>1){
                result ++;
            } else {
                findUniqueElement = true;
            }
        }

        if(!findUniqueElement){
            throw new UniqueElementException();
        }

        return result;
    }

    @Override
    public String getStrategy() {
        return Strategy.COUNT_DUPLICATES.toString();
    }
}
