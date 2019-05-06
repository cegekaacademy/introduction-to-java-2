package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.*;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws NullListException, EmptyListException, MAX_INT_Exception, NegativeNumbersException, NoDuplicatesException;

    String getStrategy();
}
