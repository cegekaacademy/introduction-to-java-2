package com.cegeka.academy.classes.math;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.service.CalculateService;
import com.cegeka.academy.util.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class Duplicate implements CalculateService {
    @Override
    public Number calculate(List numberList) {
        if (numberList == null || numberList.size() == 0) {
            throw new DuplicateException("Lista nu este corecta! Null sau goala!");
        }
        int nrDuplicate = 0;
        Map<Number, Integer> mapNumarDuplicate = new HashMap<>();

        for (Object obj : numberList) {
            Integer initialValue = 1;
            if (mapNumarDuplicate.containsKey(obj)) {
                initialValue = mapNumarDuplicate.get(obj);
                initialValue++;
            }
            mapNumarDuplicate.put((Number) obj, initialValue);
        }

        for (Number n : mapNumarDuplicate.keySet()) {
            if (mapNumarDuplicate.get(n) != 1) {
                nrDuplicate += mapNumarDuplicate.get(n);
            }
        }

        if (nrDuplicate == numberList.size()) {
            throw new DuplicateException("Lista trebuie sa contina si elemente unice, nu doar duplicate!");
        }

        return nrDuplicate;
    }

    @Override
    public String getStrategy() {
        return Strategy.COUNT_DUPLICATES.toString();
    }
}
