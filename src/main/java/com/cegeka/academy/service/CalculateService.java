package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.*;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws NullListException, SumOverMaxIntException, EmptyListException, NegativeNumberException, MissingUniqueNumbersException;

    String getStrategy();
}
