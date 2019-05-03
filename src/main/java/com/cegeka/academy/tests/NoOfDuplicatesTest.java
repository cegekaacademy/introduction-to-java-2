package com.cegeka.academy.tests;

import com.cegeka.academy.exception.NullListException;
import com.cegeka.academy.exception.UniqueElementListException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NoOfDuplicatesTest {

    @Test
    public void GIEVEN_listValid_WHEN_calculateNoOfDuplicates_THEN_returnNumber(){
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(20D);
        listaNumere.add(30D);
        listaNumere.add(30D);
        listaNumere.add(30D);
        listaNumere.add(20D);
        listaNumere.add(10D);
        int result= (int) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,listaNumere);
        assertEquals(2,result);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listNull_WHEN_calculateNoOfDuplicates_THEN_returnException() throws NullListException {
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,null);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_listEmpty_WHEN_calculateNoOfDuplicates_THEN_returnException() throws NullListException {
        List<Double> listaNumere=new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,listaNumere);
    }

    @Test(expected = UniqueElementListException.class)
    public void GIVEN_listWithNoUniqueValues_WHEN_calculateNoOfDuplicates_THEN_returnException() throws UniqueElementListException {
        List<Double> listaNumere=new ArrayList<>();
        listaNumere.add(20D);
        listaNumere.add(20D);
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES,listaNumere);
    }

}