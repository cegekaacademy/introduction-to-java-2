package com.cegeka.academy.tests;

import com.cegeka.academy.exception.MaxValueException;
import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumCalculatorTest {

    @Test
    public void GIEVEN_listValid_WHEN_calculateSum_THEN_returnSuma(){
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(20D);
        listaNumere.add(30D);
        double result= (double) MathCalculatorUtil.calculateByStrategy(Strategy.SUM,listaNumere);
        assertEquals(50,result,0.01);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listNull_WHEN_calculateSum_THEN_returnException() throws NullListException {
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,null);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listEmpty_WHEN_calculateSum_THEN_returnException() throws NullListException {
        List<Double> listaNumere=new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,listaNumere);
    }

    @Test(expected = MaxValueException.class)
    public void GIVEN_listValidButMaxValueData_WHEN_calculateSum_THEN_returnException() throws MaxValueException {
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(Double.MAX_VALUE);
        listaNumere.add(Double.MAX_VALUE);
        listaNumere.add(20D);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM,listaNumere);
    }

}