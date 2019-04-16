package com.cegeka.academy.service;

import com.cegeka.academy.exceptions.AverageException;
import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListException;
import com.cegeka.academy.exceptions.SumException;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws ListException, SumException, AverageException, DuplicatesException;

    String getStrategy();
}
