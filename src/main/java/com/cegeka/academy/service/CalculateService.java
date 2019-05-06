package com.cegeka.academy.service;


import com.cegeka.academy.exception.Exceptie;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws Exceptie;

    String getStrategy();
}
