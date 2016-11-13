package ru.tulin.storages;

import org.junit.Before;
import org.junit.Test;
import ru.tulin.products.Apple;
import ru.tulin.products.Milk;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 13.11.2016
 */
public class TrashTest {

    Trash trash = new Trash();
    Apple apple;
    Milk milk;

    boolean expectedResult;
    boolean actualResult;

    @Before
    public void init() throws ParseException {
        String createDate = "01.11.2016";
        String expireDateApple = "20.11.2016";
        String expireDateMilk = "07.11.2016";
        String currentDate = "08.11.2016";

        apple = new Apple("apple", createDate, expireDateApple, currentDate);
        milk = new Milk("milk", createDate, expireDateMilk, currentDate);
    }

    @Test
    public void whenAddAddledFoodThenTrue() throws Exception {
        expectedResult = true;
        actualResult = trash.qualityMeets(milk);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void whenAddFreshFoodThenFalse() throws Exception {
        expectedResult = false;
        actualResult = trash.qualityMeets(apple);

        assertThat(expectedResult, is(actualResult));
    }

}