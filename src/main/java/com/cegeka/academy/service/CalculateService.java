package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.UpperBoundaryException;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws ListBoundaryException, UpperBoundaryException, NegativeNumberException, DuplicatesException;

    String getStrategy();
}
