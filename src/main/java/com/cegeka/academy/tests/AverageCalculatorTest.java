package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AverageCalculatorTest {
    @Test
    public void GIVEN_listValid_WHEN_calculate_THEN_returnAverage() {
        List list = new ArrayList<>();
        list.add(10D);
        list.add(20D);
        list.add(30D);
        Number result = MathCalculatorUtil.calculateByStrategy(Strategy.AVG,list);
        assertEquals(20D,result.doubleValue(),0.01);
    }


    @Test(expected = EmptyInputException.class)
    public void GIVEN_listNull_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,list);
    }

    @Test(expected = EmptyInputException.class)
    public void GIVEN_listEmpty_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,list);
    }

    @Test(expected = NegativeNumberException.class)
    public void GIVEN_listWithNegativeElements_WHEN_calculate_THEN_returnThrowNegativeNumberException(){
        List list = new ArrayList();
        list.add(-10D);
        list.add(22D);
        list.add(-20D);
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,list);
    }


}