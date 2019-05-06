package com.cegeka.academy.tests;

import com.cegeka.academy.clase.Avg;
import com.cegeka.academy.clase.Duplicate;
import com.cegeka.academy.clase.Sum;
import com.cegeka.academy.exceptions.AvgException;
import com.cegeka.academy.exceptions.DuplicateException;
import com.cegeka.academy.exceptions.SumException;
import com.cegeka.academy.service.CalculateService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void testSum()
    {
        CalculateService<Number> calculateService=new Sum();
        List<Integer> numberList=new ArrayList<>();
        int expected=6;

        numberList.add(1);
        numberList.add(2);
        numberList.add(1);
        numberList.add(2);
        Assert.assertEquals(expected,calculateService.calculate(numberList));
    }

    @Test(expected = SumException.class)
    public void testSumException()
    {
        CalculateService<Number> calculateService=new Sum();
        List<Integer> numberList=new ArrayList<>();
        calculateService.calculate(numberList);
    }

    @Test(expected = SumException.class)
    public void testSumNULLException()
    {
        CalculateService<Number> calculateService=new Sum();
        List<Integer> numberList=null;
        calculateService.calculate(numberList);
    }

    @Test
    public void testAvg()
    {
        CalculateService<Number> calculateService=new Avg();
        List<Integer> numberList=new ArrayList<>();
        int expected=2;
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        Assert.assertEquals(expected,calculateService.calculate(numberList));
    }

    @Test(expected = AvgException.class)
    public void testAvgException()
    {
        CalculateService<Number> calculateService=new Avg();
        List<Integer> numberList=new ArrayList<>();
        calculateService.calculate(numberList);
    }

    @Test(expected = AvgException.class)
    public void testAvgNULLException()
    {
        CalculateService<Number> calculateService=new Avg();
        List<Integer> numberList=null;
        calculateService.calculate(numberList);
    }

    @Test
    public void testDuplicate() {
        CalculateService<Number> calculateService = new Duplicate();
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1);
        numberList.add(1);
        numberList.add(1);
        int expected = 3;
        Assert.assertEquals(expected, calculateService.calculate(numberList));
    }

    @Test(expected = DuplicateException.class)
    public void testDuplicateException()
    {
        CalculateService<Number> calculateService=new Duplicate();
        List<Integer> numberList=new ArrayList<>();
        calculateService.calculate(numberList);
    }

    @Test(expected = DuplicateException.class)
    public void testDuplicateNULLException()
    {
        CalculateService<Number> calculateService=new Duplicate();
        List<Integer> numberList=null;
        calculateService.calculate(numberList);
    }

}
