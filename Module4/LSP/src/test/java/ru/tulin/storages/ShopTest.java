package ru.tulin.storages;

import org.junit.Before;
import org.junit.Test;
import ru.tulin.products.Apple;
import ru.tulin.products.Bread;
import ru.tulin.products.Milk;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 13.11.2016
 */
public class ShopTest {

    Shop shop = new Shop();
    Apple apple;
    Milk milk;
    Milk milkFresh;
    Bread bread;

    boolean expectedResult;
    boolean actualResult;
    boolean actualResultWithoutDiscount;
    boolean actualResultWithDiscount;

    @Before
    public void init() throws ParseException {
        String createDate = "01.11.2016";
        String expireDateApple = "20.11.2016";
        String expireDateMilk = "10.11.2016";
        String expireDateMilkFresh = "30.11.2016";
        String expireDateBread = "07.11.2016";
        String currentDate = "08.11.2016";

        apple = new Apple("apple", createDate, expireDateApple, currentDate);
        milk = new Milk("milk", createDate, expireDateMilk, currentDate);
        milkFresh = new Milk("milkFresh", createDate, expireDateMilkFresh, currentDate);
        bread = new Bread("bread", createDate, expireDateBread, currentDate);
    }

    @Test
    public void whenAddNotVeryFreshFoodThenAddToShop() throws Exception {
        expectedResult = true;
        actualResultWithoutDiscount = shop.qualityMeets(apple);
        actualResultWithDiscount = shop.qualityMeets(milk);

        assertThat(expectedResult, is(actualResultWithoutDiscount));
        assertThat(expectedResult, is(actualResultWithDiscount));
    }

    @Test
    public void whenAddAddledFoodThenFalse() throws Exception {
        expectedResult = false;
        actualResult = shop.qualityMeets(bread);

        assertThat(expectedResult, is(actualResult));
    }

    @Test
    public void whenAddVeryFreshFoodThenFalse() throws Exception {
        expectedResult = false;
        actualResult = shop.qualityMeets(milkFresh);

        assertThat(expectedResult, is(actualResult));
    }

}