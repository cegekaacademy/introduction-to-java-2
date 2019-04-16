package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.SumMaxValueException;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws EmptyInputException, SumMaxValueException;

    String getStrategy();
}
