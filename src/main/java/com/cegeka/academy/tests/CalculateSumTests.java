package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.MaxSumException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateSumTests {

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_nullList_WHEN_calculateSum_THEN_throwException(){
        List numberList = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,numberList);
    }

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_emptyList_WHEN_calculateSum_THEN_throwException(){
        List numberList = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,numberList);
    }

    @Test
    public void GIVEN_maxSum_WHEN_calculateSum_THEN_throwException(){
        List numberList = new ArrayList();
        numberList.add(Integer.MAX_VALUE);
        numberList.add(10);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, numberList);
    }

    @Test
    public void GIVEN_validList_WHEN_calculateSum_THEN_returnGoodValue(){
        List numberList = new ArrayList();
        numberList.add(25);
        numberList.add(10);
        numberList.add(5);
        Assert.assertEquals(40, MathCalculatorUtil.calculateByStrategy(Strategy.SUM, numberList));
    }

}
