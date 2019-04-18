package com.cegeka.academy.util;

import com.cegeka.academy.classes.MathArithmeticAverage;
import com.cegeka.academy.classes.MathDuplicateCount;
import com.cegeka.academy.classes.MathSum;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = null;

    static {
        calculateServices = new ArrayList<>();
        calculateServices.add(new MathArithmeticAverage());
        calculateServices.add(new MathDuplicateCount());
        calculateServices.add(new MathSum());
    }

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}