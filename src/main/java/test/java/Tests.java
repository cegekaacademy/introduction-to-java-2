package test.java;

import com.cegeka.academy.exceptions.*;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test(expected = NullListException.class)
    public void GIVEN_nullList_WHEN_calculateSum_THEN_returnThrowException(){
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, null);
    }

    @Test(expected = EmptyListException.class)
    public void GIVEN_emptyList_WHEN_calculateSum_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, testList);
    }
    @Test(expected = MAX_INT_Exception.class)
    public void GIVEN_sumGreaterThanMAX_Int_WHEN_calculateSum_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        testList.add(Integer.MAX_VALUE);
        testList.add(Integer.MAX_VALUE);
        testList.add(10);
        MathCalculatorUtil.calculateByStrategy(Strategy.SUM, testList);

    }

    @Test
    public void GIVEN_list_WHEN_calculateSum_THEN_returnSum(){
        List<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(10);
        testList.add(-9);
        Integer sum = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.SUM, testList);
        Assert.assertEquals(9,sum,0);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_nullList_WHEN_calculateAvg_THEN_returnThrowException(){
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, null);
    }

    @Test(expected = EmptyListException.class)
    public void GIVEN_emptyList_WHEN_calculateAvg_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, testList);
    }
    @Test(expected = NegativeNumbersException.class)
    public void GIVEN_negativeNubers_WHEN_calculateAvg_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(-10);
        MathCalculatorUtil.calculateByStrategy(Strategy.AVG, testList);
    }

    @Test
    public void GIVEN_list_WHEN_calculateAvg_THEN_returnAVG(){
        List<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(10);
        testList.add(3);
        Integer avg = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.AVG, testList);
        Assert.assertEquals(7,avg,0);
    }

    @Test(expected = NullListException.class)
    public void GIVEN_nullList_WHEN_calculateDuplicates_THEN_returnThrowException(){
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, null);
    }

    @Test(expected = EmptyListException.class)
    public void GIVEN_emptyList_WHEN_calculateDuplicates_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, testList);
    }
    @Test(expected = NoDuplicatesException.class)
    public void GIVEN_noDuplicates_Int_WHEN_calculateDuplicates_THEN_returnThrowException(){
        List<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(8);

        Integer noOfDuplicates = (Integer)MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, testList);

    }

    @Test
    public void GIVEN_list_WHEN_calculateDuplicates_THEN_returnNoOfDuplicates(){
        List<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(8);
        testList.add(-9);
        testList.add(1);
        testList.add(1);
        testList.add(7);

        Integer noOfDuplicates = (Integer) MathCalculatorUtil.calculateByStrategy(Strategy.COUNT_DUPLICATES, testList);
        Assert.assertEquals(2,noOfDuplicates,0);
    }

}
