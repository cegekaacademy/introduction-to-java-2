package com.cegeka.academy.util;

import com.cegeka.academy.classes.math.Average;
import com.cegeka.academy.classes.math.Duplicate;
import com.cegeka.academy.classes.math.Sum;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices;

    static {
        calculateServices = new ArrayList<>();
        calculateServices.add(new Average());
        calculateServices.add(new Duplicate());
        calculateServices.add(new Sum());
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