package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.MaxSumException;
import com.cegeka.academy.exceptions.NegativeNumbersListException;
import com.cegeka.academy.methods.CalculateSum;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateAverageTests {

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_nullList_WHEN_calculateAverage_THEN_throwException(){
        List numberList = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,numberList);
    }

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_emptyList_WHEN_calculateAverage_THEN_throwException(){
        List numberList = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,numberList);
    }

    @Test
    public void GIVEN_negativeNumbers_WHEN_calculateAverage_THEN_throwException(){
        List numberList = new ArrayList();
        numberList.add(-1);
        numberList.add(10);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, numberList);
    }

    @Test
    public void GIVEN_validList_WHEN_calculateAverage_THEN_returnGoodValue(){
        List numberList = new ArrayList();
        numberList.add(15);
        numberList.add(10);
        numberList.add(5);
        Assert.assertEquals(10, MathCalculatorUtil.calculateByStrategy(Strategy.AVG, numberList));
    }


}
