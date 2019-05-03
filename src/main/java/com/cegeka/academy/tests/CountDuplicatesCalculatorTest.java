package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.EmptyInputException;
import com.cegeka.academy.exceptions.UniqueElementException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CountDuplicatesCalculatorTest {

    @Test
    public void GIVEN_listValid_WHEN_calculate_THEN_returnNoOfDuplicates() {
        List list = new ArrayList();
        list.add(10D);
        list.add(20D);
        list.add(10D);
        list.add(10D);
        list.add(20D);
        list.add(30D);
        Number result = MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,list);
        assertEquals(2,result.intValue());
    }


    @Test(expected = EmptyInputException.class)
    public void GIVEN_listNull_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,list);
    }

    @Test(expected = EmptyInputException.class)
    public void GIVEN_listEmpty_WHEN_calculate_THEN_returnThrowEmptyInputException(){
        List list = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,list);
    }

    @Test(expected = UniqueElementException.class)
    public void GIVEN_listWithNoUniqueElement_WHEN_calculate_THEN_returnThrowUniqueElementException(){
        List list = new ArrayList();
        list.add(22D);
        list.add(20D);
        list.add(22D);
        list.add(20D);

        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,list);
    }

}