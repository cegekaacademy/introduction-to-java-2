package com.cegeka.academy.teste;

import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MedieTest {

    @Test(expected = NullException.class)
    public void GIVEN_nullList_WHEN_calculate_THEN_throwException(){
        List lista = null;
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, lista);
    }

    @Test(expected = NullException.class)
    public void GIVEN_emptyList_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, lista);
    }

    @Test(expected = NegativeNumberException.class)
    public void GIVEN_negativeNumbers_WHEN_calculate_THEN_throwException(){
        List lista = new ArrayList();
        lista.add(1);
        lista.add(-3);
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, lista);
    }

    @Test
    public void GIVEN_validInput_WHEN_calculate_THEN_returnAvg(){
        List lista = new ArrayList();
        lista.add(1);
        lista.add(3);
        lista.add(5);
        Number result = MathCalculatorUtil.calculateByStrategy(Strategy.AVG,lista);
        Assert.assertEquals(3,result);
    }

}
