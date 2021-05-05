package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestDiv {
    Calculator calculator;

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{50.0, 5.0, 10.0}};
    }

    @BeforeMethod(groups = "multDiv")
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "correctData", groups = "multDiv")
    public void testCalculatorDivide(double dividend, double divisor, double expectedResult) {
        double actual = calculator.div(dividend, divisor);
        assertEquals(actual, expectedResult);
    }

    @AfterMethod(groups = "multDiv")
    public void after() {
        calculator = null;
    }
}
