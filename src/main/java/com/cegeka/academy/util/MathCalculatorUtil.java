package com.cegeka.academy.util;

import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = new ArrayList<>();
    private static CalculateService suma=new SumCalculator();
    private static CalculateService avg=new AverageCalculator();
    private static CalculateService nrDuplicate=new NoOfDuplicates();

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
       calculateServices.add(suma);
       calculateServices.add(avg);
       calculateServices.add(nrDuplicate);

        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}