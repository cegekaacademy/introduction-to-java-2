package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.UpperBoundaryException;
import com.cegeka.academy.service.CalculateMean;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.service.CalculateSum;
import com.cegeka.academy.service.DuplicatesCounter;

import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = new ArrayList<>();

    public MathCalculatorUtil() {
        calculateServices.add(new CalculateSum());
        calculateServices.add(new CalculateMean());
        calculateServices.add(new DuplicatesCounter());
    }

    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) throws NegativeNumberException, ListBoundaryException, UpperBoundaryException, DuplicatesException {
        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }
}