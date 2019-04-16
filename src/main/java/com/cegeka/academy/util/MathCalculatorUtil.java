package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.ListException;
import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = null; // TODO create a list with all CalculateService implementations

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) throws ListException {
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}

