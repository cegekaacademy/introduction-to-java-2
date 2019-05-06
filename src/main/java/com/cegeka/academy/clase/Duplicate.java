package com.cegeka.academy.clase;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.service.CalculateService;

import java.util.*;

public class Duplicate implements CalculateService {

    @Override
    public Number calculate(List numberList)
    {
        if(numberList==null|| numberList.size()==0)
        {
            throw new DuplicateException();
        }
        int nr=0;
        Set<List> set=new HashSet<>();
        set.add(numberList);
        nr=numberList.size()-set.size();
        return nr;

    }

    @Override
    public String getStrategy() {
        return null;
    }
}
