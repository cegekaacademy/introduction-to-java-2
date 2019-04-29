package com.cegeka.academy.util;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.service.CalculateService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MathCalculatorUtil {

    private static List<CalculateService> calculateServices = null;
    private static Strategy startegy;


    public static Number calculateByStrategy(Strategy strategy, List<? extends Number> list) throws NegativeNumberException, SumOverMaxIntException, EmptyListException, NullListException, NullStrategyException {

        if(strategy == null)
            throw new NullStrategyException();

        for (CalculateService service: calculateServices) {
            if(service.getStrategy().equals(strategy.name())){
                return service.calculate(list);
            }
        }

        throw new RuntimeException("you should not be here");
    }

    static{
        calculateServices = new ArrayList<CalculateService>();

        calculateServices.add(new CalculateService() {
            @Override
            public Number calculate(List numberList) throws NullListException, SumOverMaxIntException, EmptyListException {

                if(numberList == null)
                    throw new NullListException();
                if(numberList.size() == 0)
                    throw new EmptyListException();

                int suma = 0;

                for(Object n : numberList)
                {
                    if(Integer.MAX_VALUE - suma < (Integer) n)
                        throw new SumOverMaxIntException();
                    suma += (Integer) n;
                }
                return suma;
            }

            @Override
            public String getStrategy() {
                return Strategy.SUM.toString();
            }
        });

        calculateServices.add(new CalculateService() {
            @Override
            public Number calculate(List numberList) throws NullListException, SumOverMaxIntException, EmptyListException, NegativeNumberException {

                if(numberList == null)
                    throw new NullListException();
                if(numberList.size() == 0)
                    throw new EmptyListException();

                int suma = 0;

                for(Object n : numberList)
                {
                    if((Integer) n < 0)
                        throw new NegativeNumberException();

                    if(Integer.MAX_VALUE - suma < (Integer) n)
                        throw new SumOverMaxIntException();
                    suma += (Integer) n;
                }
                return suma / numberList.size();
            }

            @Override
            public String getStrategy() {
                return Strategy.AVG.toString();
            }
        });

    }
}