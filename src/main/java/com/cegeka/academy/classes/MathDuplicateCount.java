package com.cegeka.academy.classes;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.SumaException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathDuplicateCount implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new DuplicateException("Lista nu este corecta! Null sau goala!");
        }

        int nrDuplicate = 0;
        Map<Number, Integer> mapNumarDuplicate = new HashMap<Number, Integer>();

        for (Object obj : numberList) {
            Integer initValue = 1;
            if (mapNumarDuplicate.get((Number)obj) != 0) {
                initValue = mapNumarDuplicate.get((Number)obj);
                initValue++;
            }
            mapNumarDuplicate.put((Number)obj, initValue);
        }

        for (Number n : mapNumarDuplicate.keySet()) {
            if (mapNumarDuplicate.get(n) != 1) {
                nrDuplicate += mapNumarDuplicate.get(n) - 1;
            }
        }

        if (nrDuplicate == numberList.size()) {
            throw new DuplicateException("Lista nu este corecta! Null sau goala!");
        }

        return nrDuplicate;
    }

    @Override
    public String getStrategy() {
        return Strategy.COUNT_DUPLICATES.toString();
    }
}
