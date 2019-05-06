package com.cegeka.academy.classes;

import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class CalculateAvg implements CalculateService {

    CalculateSum calculateSum = null;

    @Override
    public Number calculate(List numberList) throws Exception {

        Integer sum = calculateSum.calculate(numberList);

        return sum/numberList.size();
    }

    @Override
    public String getStrategy() {
        return "AVG";
    }
}
