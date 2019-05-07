package com.cegeka.academy.util;

import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static CalculateService suma = new Suma();
    private static CalculateService medie = new Medie();
    private static CalculateService duplicate = new NrDuplicate();
    private static List<CalculateService> calculateServices = new ArrayList();



    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
        calculateServices.add(suma);
        calculateServices.add(medie);
        calculateServices.add(duplicate);
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}