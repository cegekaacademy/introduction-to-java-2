package com.cegeka.academy.classes;

import com.cegeka.academy.service.CalculateService;

import java.util.List;

import static java.lang.Integer.*;

public class CalculateSum implements CalculateService<Integer> {


    @Override
    public Integer calculate(List numberList) throws Exception {

        if(numberList.isEmpty() || numberList == null){
            throw new Exception("Lista trebuie sa contina valori");
        }

        Integer total = 0;

        for(Object number : numberList) {
            if ((Integer) number >= 0) {
                if (total > (MAX_VALUE - (Integer) number)) {
                    throw new Exception();
                }
                total += (Integer) number;
            } else{
                throw new Exception("Nu pot exista valori negative");
            }
        }
        return total;
    }

    @Override
    public String getStrategy() {
        return "SUM";
    }
}
