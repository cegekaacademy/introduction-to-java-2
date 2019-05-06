package com.cegeka.academy.clase;

import com.cegeka.academy.exceptions.AvgException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class Avg implements CalculateService {


    @Override
    public Number calculate(List numberList) {

        int avg=0;

        if( numberList==null||numberList.size()==0)
            throw new AvgException();

        for(Object obj: numberList)
        {
            avg+=(Integer)obj;
        }

        return avg/numberList.size();

    }

    @Override
    public String getStrategy() {
        return null;
    }
}
