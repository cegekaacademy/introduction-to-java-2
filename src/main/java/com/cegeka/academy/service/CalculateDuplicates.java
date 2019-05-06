package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.util.Strategy;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateDuplicates implements CalculateService<Integer>{


    @Override
    public Integer calculate(List<? extends Number> numberList) throws NullListException, EmptyListException, MAX_INT_Exception, NegativeNumbersException, NoDuplicatesException {

        if (numberList== null)
            throw new NullListException("Null list.");
        if (numberList.isEmpty())
            throw new EmptyListException("Empty list.");
        int duplicateCount =0;
        boolean uniqueElements = false;
        Set<? extends Number> duplicates = new HashSet<Number>(numberList);

        for (Object number: duplicates){
            if (Collections.frequency(numberList,number)> 1)
                duplicateCount =duplicateCount+1;
            else
                uniqueElements = true;

        }
        if (uniqueElements == false)
            throw new NoDuplicatesException("No unique elements.");

        return duplicateCount;
    }

    @Override
    public String getStrategy() {
        return Strategy.COUNT_DUPLICATES.toString();
    }
}
