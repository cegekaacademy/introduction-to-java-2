package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.UpperBoundaryException;
import com.cegeka.academy.util.Strategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DuplicatesCounter implements CalculateService<Integer> {

    @Override
    public Integer calculate(List<? extends Number> numberList) throws ListBoundaryException, DuplicatesException {
        if (numberList == null || numberList.isEmpty())
            throw new ListBoundaryException();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Object number : numberList) {
            if (hashMap.containsKey((Integer) number))
                hashMap.put((Integer) number, hashMap.get((Integer) number) + 1);
            else
                hashMap.put((Integer) number, 1);
        }
        int counter = 0;
        for (Map.Entry mapElement : hashMap.entrySet()) {
            if ((int) mapElement.getValue() > 1)
                counter++;
        }

        if (counter == numberList.size())
            throw new DuplicatesException();

      return counter;

    }

    @Override
    public String getStrategy() {
        return String.valueOf(Strategy.COUNT_DUPLICATES);
    }
}
