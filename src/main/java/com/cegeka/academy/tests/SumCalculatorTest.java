package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.SumMaxValueException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumCalculatorTest {

    @Test
    public void GIVEN_listValid_WHEN_calculate_THEN_returnSum(){
        List list = new ArrayList<>();
        list.add(10D);
        list.add(20D);
        list.add(30D);
        Number result = MathCalculatorUtil.calculateByStrategy(Strategy.SUM,list);
        assertEquals(60D,result.doubleValue(),0.01);
    }

    @Test(expected = EmptyInputException.class)
    public void GIVEN_listNull_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,list);
    }

    @Test(expected = EmptyInputException.class)
    public void GIVEN_listEmpty_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,list);
    }

    @Test(expected = SumMaxValueException.class)
    public void GIVEN_listWithMaxValue_WHEN_calculate_THEN_returnThrowSumMaxValueException(){
        List list = new ArrayList();
        list.add(10D);
        list.add(Double.MAX_VALUE);
        list.add(Double.MAX_VALUE);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,list);
    }

}