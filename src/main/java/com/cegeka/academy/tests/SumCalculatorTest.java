package com.cegeka.academy.tests;

import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumCalculatorTest {

    @Test
    public void GIVEN_listValid_WHEN_calculate_THEN_returnSum(){
        List<Double>list = new ArrayList<>();
        list.add(10D);
        list.add(20D);
        list.add(30D);
        Number result = MathCalculatorUtil.calculateByStrategy(Strategy.SUM,list);
        assertEquals(60D,result.doubleValue(),0.01);
    }

}