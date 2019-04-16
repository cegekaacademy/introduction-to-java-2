package com.cegeka.academy.util;

import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class MathCalculatorUtil {

    private static SumCalculator sumCalculator;
    private static AverageCalculator averageCalculator;
    private static CountDuplicatesCalculator countDuplicatesCalculator;

    private static List<CalculateService> calculateServices = null; // TODO create a list with all CalculateService implementations

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
        calculateServices.add(sumCalculator);
        calculateServices.add(averageCalculator);
        calculateServices.add(countDuplicatesCalculator);

        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}