package com.cegeka.academy.tests;

import com.cegeka.academy.exception.NegativeNumberException;
import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AverageCalculatorTest {

    @Test
    public void GIEVEN_listValid_WHEN_calculateAverage_THEN_returnAverage(){
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(20D);
        listaNumere.add(30D);
        listaNumere.add(40D);
        double result= (double) MathCalculatorUtil.calculateByStrategy(Strategy.AVG,listaNumere);
        assertEquals(30,result,0.01);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listNull_WHEN_calculateAverage_THEN_returnException() throws NullListException {
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,null);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listEmpty_WHEN_calculateAverage_THEN_returnException() throws NullListException {
        List<Double> listaNumere=new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,listaNumere);
    }

    @Test(expected = NegativeNumberException.class)
    public void GIVEN_listWithNegativeNumbers_WHEN_calculateAverage_THEN_returnException() throws NegativeNumberException {
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(-20D);
        listaNumere.add(30D);
        listaNumere.add(40D);
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG,listaNumere);
    }


}