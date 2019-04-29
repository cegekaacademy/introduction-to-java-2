package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.EmptyListException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.NullListException;
import com.cegeka.academy.exceptions.SumOverMaxIntException;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws NullListException, SumOverMaxIntException, EmptyListException, NegativeNumberException;

    String getStrategy();
}
