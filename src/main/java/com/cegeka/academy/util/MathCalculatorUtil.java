package com.cegeka.academy.util;

import com.cegeka.academy.methods.CalculateAverage;
import com.cegeka.academy.methods.CalculateDuplicatesCount;
import com.cegeka.academy.methods.CalculateSum;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = new ArrayList<>(); 
    private static CalculateSum sum = new CalculateSum();
    private static CalculateAverage avg = new CalculateAverage();
    private static CalculateDuplicatesCount count = new CalculateDuplicatesCount();


    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
        calculateServices.add(sum);
        calculateServices.add(avg);
        calculateServices.add(count);
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}