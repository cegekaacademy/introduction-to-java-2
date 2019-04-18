package com.cegeka.academy.testing;


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

}
