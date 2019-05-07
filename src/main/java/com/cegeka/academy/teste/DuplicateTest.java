package com.cegeka.academy.teste;

import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DuplicateTest {

    @Test(expected = NullException.class)
    public void GIVEN_nullList_WHEN_calculate_THEN_throwException(){
        List lista = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
    }

    @Test(expected = NullException.class)
    public void GIVEN_emptyList_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
    }

    @Test(expected = DuplicateException.class)
    public void GIVEN_onlyDuplicates_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(3);
        lista.add(4);
        lista.add(4);
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
    }

    @Test(expected = DuplicateException.class)
    public void GIVEN_noDuplicates_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        lista.add(2);
        lista.add(1);
        lista.add(3);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
    }

    @Test
    public void GIVEN_validInput_WHEN_calculate_THEN_returnNoOfDuplicates(){
        List lista = new ArrayList();
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(6);
        lista.add(6);
        lista.add(8);
        Number nr = MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, lista);
        Assert.assertEquals(2, nr);
    }
}

