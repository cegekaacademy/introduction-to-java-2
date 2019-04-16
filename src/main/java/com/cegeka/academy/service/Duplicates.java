package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Duplicates implements CalculateService{
    @Override
    public Number calculate(List numberList) throws ListException, DuplicatesException {
        if (numberList == null || numberList.isEmpty()) {
            throw new ListException("The list doesn't exist");
        }

        int duplicates = 0;
        ArrayList uniqueList = new ArrayList();

        for (Object i:numberList) {
            if(!uniqueList.contains(i))
                uniqueList.add(i);
            else
                duplicates++;
        }

        if()

        return duplicates;
    }

    @Override
    public String getStrategy() {
        return "COUNT_DUPLICATES";
    }
}
