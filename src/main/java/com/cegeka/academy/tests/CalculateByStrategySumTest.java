package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CalculateByStrategySumTest {

    ArrayList<Number> numberList;

    @Before
    public void setUp() throws Exception {
        numberList = new ArrayList<>();
        numberList.add(40);
        numberList.add(10);
        numberList.add(1000);
    }

    @Test(expected = NullStrategyException.class)
     public void GIVEN_NullStrategy_WHEN_CalculateByStrategy_THEN_NullStrategyException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException {
        MathCalculatorUtil.calculateByStrategy(null, numberList);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_NullList_WHEN_CalculateByStrategy_THEN_NullListException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException {
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,null);
    }

    @Test(expected = EmptyListException.class)
    public void GIVEN_EmptyList_WHEN_CalculateByStrategy_THEN_EmptyListException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException {
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, new ArrayList<>());
    }

    @Test(expected = SumOverMaxIntException.class)
    public void GIVEN_SumOverMaxInt_WHEN_CalculateByStrategy_THEN_SumOverMaxIntException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException {
        numberList.add(Integer.MAX_VALUE);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, numberList);
    }
}
