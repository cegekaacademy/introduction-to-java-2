package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyNullListException;
import com.cegeka.academy.exceptions.UniqueElementsException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateDuplicatesCountTests {

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_nullList_WHEN_calculateDuplicatesCount_THEN_throwException(){
        List numberList = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,numberList);
    }

    @Test(expected = EmptyNullListException.class)
    public void GIVEN_emptyList_WHEN_calculateDuplicatesCount_THEN_throwException(){
        List numberList = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,numberList);
    }

    @Test(expected = UniqueElementsException.class)
    public void GIVEN_noDuplicates_WHEN_calculateDuplicatesCount_THEN_throwException(){
        List numberList = new ArrayList();
        numberList.add(-1);
        numberList.add(10);
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
    }

    @Test
    public void GIVEN_validList_WHEN_calculateDuplicatesCount_THEN_returnGoodValue(){
        List numberList = new ArrayList();
        numberList.add(15);
        numberList.add(15);
        numberList.add(10);
        numberList.add(2);
        numberList.add(10);
        numberList.add(5);
        Assert.assertEquals(2, MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList));
    }

}
