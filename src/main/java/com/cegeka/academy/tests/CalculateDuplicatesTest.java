package com.cegeka.academy.tests;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CalculateDuplicatesTest {

    ArrayList<Number> numberList;

    @Before
    public void setUp() throws Exception {
        numberList = new ArrayList<>();
    }

    @Test(expected = NullStrategyException.class)
    public void GIVEN_NullStrategy_WHEN_CalculateByStrategy_THEN_NullStrategyException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException, MissingUniqueNumbersException {
        MathCalculatorUtil.calculateByStrategy(null, numberList);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_NullList_WHEN_CalculateByStrategy_THEN_NullListException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException, MissingUniqueNumbersException {
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,null);
    }

    @Test(expected = EmptyListException.class)
    public void GIVEN_EmptyList_WHEN_CalculateByStrategy_THEN_EmptyListException() throws NegativeNumberException, SumOverMaxIntException, NullStrategyException, EmptyListException, NullListException, MissingUniqueNumbersException {
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, new ArrayList<>());
    }

    @Test(expected = MissingUniqueNumbersException.class)
    public void GIVEN_ListMadeOfOnlyDuplicatedNumbers_WHEN_CalculateByStrategy_THEN_MissingUniqueNumbersException() throws MissingUniqueNumbersException, NullStrategyException, NullListException, NegativeNumberException, EmptyListException, SumOverMaxIntException {
        numberList.add(1);
        numberList.add(1);
        numberList.add(1);
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
    }

    @Test
    public void GIVEN_ListMadeOfUniqueOrderedNumbers_WHEN_CalculateByStrategy_THEN_ExpectedIsZero() throws MissingUniqueNumbersException, NullStrategyException, NullListException, NegativeNumberException, EmptyListException, SumOverMaxIntException {
        for(int i = 0; i < 3000; i++)
        {
            numberList.add(i);
        }
        int expected = 0;
        int actual = (int) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
        assertEquals("Unique consecutive number test", expected, actual);
    }

    @Test
    public void GIVEN_ListMadeOfUniqueDescendingOrderedNumbers_WHEN_CalculateByStrategy_THEN_ExpectedIsZero() throws MissingUniqueNumbersException, NullStrategyException, NullListException, NegativeNumberException, EmptyListException, SumOverMaxIntException {
        for(int i = 2999; i >= 0; i--)
        {
            numberList.add(i);
        }
        int expected = 0;
        int actual = (int) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
        assertEquals("Unique consecutive descending number test", expected, actual);
    }

    @Test
    public void GIVEN_ListMadeOfTwiceDuplicatedNumbersExceptOneUniqueNumberTheGreatest_WHEN_CalculateByStrategy_THEN_ExpectedIsHalfOfTheSizeOfTheList() throws MissingUniqueNumbersException, NullStrategyException, NullListException, NegativeNumberException, EmptyListException, SumOverMaxIntException {
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 3000; j++)
                numberList.add(j);
         numberList.add(6000);
         int expected = numberList.size() / 2;
         int actual = (int) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
         assertEquals("Twice Duplicated Numbers Test", expected, actual);
    }

    @Test
    public void GIVEN_ListMadeOfTwiceDuplicatedNumbersExceptOneUniqueNumberTheSmallest_WHEN_CalculateByStrategy_THEN_ExpectedNumberOfDuplicates() throws MissingUniqueNumbersException, NullStrategyException, NullListException, NegativeNumberException, EmptyListException, SumOverMaxIntException {
        for(int i = 0; i < 2; i++)
            for(int j = 1000; j < 1004; j++)
                numberList.add(j);
        numberList.add(10);
        int expected = numberList.size() / 2;
        int actual = (int) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, numberList);
        assertEquals("Twice Duplicated Numbers Test", expected, actual);
    }
}
