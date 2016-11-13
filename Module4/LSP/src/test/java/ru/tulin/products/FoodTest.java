package ru.tulin.products;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 13.11.2016
 */
public class FoodTest {

    Food food;

    String createDate = "01.11.2016";
    String expireDate = "11.11.2016";
    String currentDate = "06.11.2016";

    @Before
    public void init() throws ParseException {
        food = new Apple("apple", createDate, expireDate, currentDate);
    }

    @Test
    public void getFreshnessPercentage() throws Exception {
        double expectedResult = 0.5;
        double actualResult = food.getFreshnessPercentage();

        assertThat(expectedResult, is(actualResult));
    }

}