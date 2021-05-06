package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSubtract {
    Calculator calculator;

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{50, 25, 25}};
    }

    @BeforeMethod(groups = "addSub")
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "correctData", groups = "addSub")
    public void testCalculatorSubtract(long minuend, long subtrahend, long expectedResult) {
        long actual = calculator.sub(minuend, subtrahend);
        assertEquals(actual, expectedResult);
    }

    @AfterMethod(groups = "addSub")
    public void after() {
        calculator = null;
    }
}
