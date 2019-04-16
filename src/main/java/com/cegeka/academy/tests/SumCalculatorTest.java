package com.cegeka.academy.tests;

import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import com.cegeka.academy.util.SumCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumCalculatorTest {

    @Test
    public void GIEVEN_listValid_WHEN_calculate_THEN_returnSuma(){
        List listaNumere=new ArrayList<>();
        listaNumere.add(20);
        listaNumere.add(30);
        int result= (int) MathCalculatorUtil.calculateByStrategy(Strategy.SUM,listaNumere);
        assertEquals(50,result,0.01);

    }

}