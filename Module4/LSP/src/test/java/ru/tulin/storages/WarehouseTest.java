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
public class WarehouseTest {

    Warehouse warehouse = new Warehouse();
    Apple apple;
    Milk milk;

    boolean expectedResult;
    boolean actualResult;

    @Before
    public void init() throws ParseException {
        String createDate = "01.11.2016";
        String expireDateApple = "20.11.2016";
        String expireDateMilk = "30.11.2016";
        String currentDate = "08.11.2016";

        apple = new Apple("apple", createDate, expireDateApple, currentDate);
        milk = new Milk("milk", createDate, expireDateMilk, currentDate);
    }

    @Test
    public void whenAddFreshFoodToWarehouseThenTrue() throws Exception {
        expectedResult = true;
        actualResult = warehouse.qualityMeets(milk);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void whenAddNotFreshFoodToWarehouseThenFalse() throws Exception {
        expectedResult = false;
        actualResult = warehouse.qualityMeets(apple);

        assertThat(expectedResult, is(actualResult));
    }

}