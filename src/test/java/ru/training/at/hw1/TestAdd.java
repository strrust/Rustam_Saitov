package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAdd {
    Calculator calculator;

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{25, 25, 50}};
    }

    @BeforeMethod(groups = "addSub")
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "correctData", groups = "addSub")
    public void testCalculatorSum(long summand1, long summand2, long expectedResult) {
        long actual = calculator.sum(summand1, summand2);
        assertEquals(actual, expectedResult);
    }

    @AfterMethod(groups = "addSub")
    public void after() {
        calculator = null;
    }
}
