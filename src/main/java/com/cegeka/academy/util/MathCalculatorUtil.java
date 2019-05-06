package com.cegeka.academy.util;

import com.cegeka.academy.service.CalculateService;

import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = null; // TODO create a list with all CalculateService implementations

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) {
        return calculateServices.stream()
                .filter(service -> service.getStrategy().equals(strategy.name()))
                .findFirst()
                .map(calculateService -> calculateService.calculate(list))
                .get();
    }



}