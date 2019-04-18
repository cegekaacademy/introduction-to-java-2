package com.cegeka.academy.testing;


import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.AverageException;
import com.cegeka.academy.exceptions.SumException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MathCalculatorUtilTest {

    @Test
    public void GIVEN_strategySum_WHEN_calculateByStrategy_THEN_returnCorrect() {
        List<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(15);
        Integer result = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
        assertEquals(25, result, 0.01d);

    }

    @Test(expected = SumException.class)
    public void GIVEN_strategySumNullList_WHEN_calculateByStrategy_THEN_returnError() {
        List<Integer> lista = null;
        Integer result = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
        assertEquals(25, result, 0.01d);
    }

    @Test
    public void GIVEN_strategyCount_WHEN_calculateByStrategy_THEN_returnCorrect() {
        List<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(15);
        lista.add(15);
        lista.add(15);
        lista.add(30);
        Integer result = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
        assertEquals(3, result, 0.01d);
    }

    @Test(expected = DuplicateException.class)
    public void GIVEN_strategyCountAndOnlyDuplicates_WHEN_calculateByStrategy_THEN_returnError() {
        List<Integer> lista = new ArrayList<>();
        lista.add(15);
        lista.add(15);
        Integer result = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
        assertEquals(3, result, 0.01d);
    }

    @Test
    public void GIVEN_strategyAverage_WHEN_calculateByStrategy_THEN_returnCorrect() {
        List<Double> lista = new ArrayList<>();
        lista.add(11.5);
        lista.add(12.5);
        Double result = (Double) MathCalculatorUtil.calculateByStrategy(Strategy.AVG, lista);
        Assert.assertEquals(12, result, 0.01d);
    }

    @Test(expected = AverageException.class)
    public void GIVEN_strategyAverageWithNegativeElement_WHEN_calculateByStrategy_THEN_returnError() {
        List<Double> lista = new ArrayList<>();
        lista.add(11.5);
        lista.add(-12.5);
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, lista);
    }

}
