package com.cegeka.academy.util;

import com.cegeka.academy.classes.CalculateAvg;
import com.cegeka.academy.classes.CalculateSum;
import com.cegeka.academy.classes.CountDuplicates;
import com.cegeka.academy.service.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices;

    static {
        calculateServices = new ArrayList<>();

        calculateServices.add(new CalculateSum());
        calculateServices.add(new CalculateAvg());
        calculateServices.add(new CountDuplicates());

        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);

        try {
            System.out.println(calculateByStrategy(Strategy.SUM, list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) throws Exception {
        if(list.isEmpty() || list== null) {
            throw new Exception();
        }
        for (CalculateService service : calculateServices) {
            if (service.getStrategy().equals(strategy.name())) {
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}