package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.service.CalculateAvg;
import com.cegeka.academy.service.CalculateDuplicates;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.service.CalculateSum;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = new ArrayList<>();// TODO create a list with all CalculateService implementations

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list)  {
        calculateServices.add(new CalculateSum());
        calculateServices.add(new CalculateAvg());
        calculateServices.add(new CalculateDuplicates());
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                  return service.calculate(list);

            }
        }

        throw new RuntimeException("you should not be here");
    }
}