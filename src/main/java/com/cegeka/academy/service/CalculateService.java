package com.cegeka.academy.service;

import java.util.List;

public interface CalculateService<T extends Number> {

    T calculate(List<? extends Number> numberList) throws Exception;

    String getStrategy();
}
