package test.java;

import com.cegeka.academy.exceptions.DuplicatesException;
import com.cegeka.academy.exceptions.ListBoundaryException;
import com.cegeka.academy.exceptions.NegativeNumberException;
import com.cegeka.academy.exceptions.UpperBoundaryException;
import com.cegeka.academy.service.CalculateMean;
import com.cegeka.academy.service.CalculateSum;
import com.cegeka.academy.service.DuplicatesCounter;
import com.cegeka.academy.util.MathCalculatorUtil;
import com.cegeka.academy.util.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {

    @Test(expected = ListBoundaryException.class)
    public void testSumNull() throws UpperBoundaryException, ListBoundaryException {
        CalculateSum calculateSum = new CalculateSum();
        calculateSum.calculate(null);
    }

    @Test(expected = ListBoundaryException.class)
    public void testSumEmpty() throws UpperBoundaryException, ListBoundaryException {
        CalculateSum calculateSum = new CalculateSum();
        calculateSum.calculate(new ArrayList());
    }

    @Test
    public void testSum() throws UpperBoundaryException, ListBoundaryException {
        CalculateSum calculateSum = new CalculateSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int sum = calculateSum.calculate(numbers);
        Assert.assertEquals(6, sum);
    }

    @Test(expected = UpperBoundaryException.class)
    public void testSumMax() throws UpperBoundaryException, ListBoundaryException {
        CalculateSum calculateSum = new CalculateSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(Integer.MAX_VALUE);
        numbers.add(1);
        numbers.add(2);
        calculateSum.calculate(numbers);
    }

    @Test(expected = NegativeNumberException.class)
    public void testMeanNegativesElements() throws ListBoundaryException, NegativeNumberException {
        CalculateMean calculateMean = new CalculateMean();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(-1);
        numbers.add(2);
        calculateMean.calculate(numbers);
    }

    @Test
    public void testMean() throws ListBoundaryException, NegativeNumberException {
        CalculateMean calculateMean = new CalculateMean();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(4);
        numbers.add(4);
        double mean = calculateMean.calculate(numbers);
        Assert.assertEquals(6.0F, mean, 0);
    }

    @Test
    public void testDuplicates() throws DuplicatesException, ListBoundaryException {
        DuplicatesCounter duplicatesCounter = new DuplicatesCounter();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        int numberOfDuplicates = duplicatesCounter.calculate(numbers);
        Assert.assertEquals(2, numberOfDuplicates);
    }

    @Test(expected = DuplicatesException.class)
    public void testDuplicatesException() throws DuplicatesException, ListBoundaryException {
        DuplicatesCounter duplicatesCounter = new DuplicatesCounter();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(2);
        duplicatesCounter.calculate(numbers);
    }

    @Test
    public void testMathCalculatorUtil() throws NegativeNumberException, ListBoundaryException, UpperBoundaryException, DuplicatesException {
        MathCalculatorUtil mathCalculatorUtil = new MathCalculatorUtil();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(2);
        int result = (Integer) mathCalculatorUtil.calculateByStrategy(Strategy.SUM, numbers);
        Assert.assertEquals(6, result);

    }
}
