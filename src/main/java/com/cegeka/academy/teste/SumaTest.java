package com.cegeka.academy.teste;

import com.cegeka.academy.exceptions.MaxValueException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumaTest {

    @org.junit.Test
    public void GIVEN_listValid_WHEN_calculate_THEN_returnSuma() {

        List lista = new ArrayList<>();
        lista.add(2);
        lista.add(5);
        lista.add(9);

        Number suma = MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
        Assert.assertEquals(16, suma);
    }

    @Test
    public void GIVEN_maxValueElement_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        lista.add(1);
        lista.add(4);
        lista.add(Integer.MAX_VALUE);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
    }

    @Test(expected = NullException.class)
    public void GIVEN_nullList_WHEN_calculate_THEN_throwException(){
        List lista = null;
        Number suma = MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
    }

    @Test(expected = NullException.class)
    public void GIVEN_emptyList_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, lista);
    }
}