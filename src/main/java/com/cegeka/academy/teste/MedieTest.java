package com.cegeka.academy.teste;

import com.cegeka.academy.exceptions.NullException;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
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

}
