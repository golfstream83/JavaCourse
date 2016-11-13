package ru.tulin.actions;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import ru.tulin.products.Apple;
import ru.tulin.products.Bread;
import ru.tulin.products.Food;
import ru.tulin.products.Milk;
import ru.tulin.storages.Shop;
import ru.tulin.storages.Storage;
import ru.tulin.storages.Trash;
import ru.tulin.storages.Warehouse;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.11.2016
 */
public class ControllQualityTest {

    ControllQuality controllQuality = new ControllQuality();

    Shop shop = new Shop();
    Warehouse warehouse = new Warehouse();
    Trash trash = new Trash();

    Apple apple;
    Apple appleDiscount;
    Milk milk;
    Bread bread;

    @Before
    public void init() throws ParseException {
        String createDate = "01.11.2016";
        String expireDateApple = "20.11.2016";
        String expireDateAppleDiscount = "10.11.2016";
        String expireDateMilk = "30.11.2016";
        String expireDateBread = "07.11.2016";
        String currentDate = "08.11.2016";

        apple = new Apple("apple", createDate, expireDateApple, currentDate);
        appleDiscount = new Apple("appleDiscount", createDate, expireDateAppleDiscount, currentDate);
        milk = new Milk("milk", createDate, expireDateMilk, currentDate);
        bread = new Bread("bread", createDate, expireDateBread, currentDate);
    }

    @Test
    public void whenAddNewStorageThenAddStorage() throws Exception {
        controllQuality.addStorage(shop);
        Storage actualResult = controllQuality.getStorages()[0];

        assertThat(shop, is(actualResult));
    }

    @Test
    public void  whenAddDifferentQualityFoodThenDistributedByStorages() throws Exception {
        controllQuality.addStorage(shop);
        controllQuality.addStorage(warehouse);
        controllQuality.addStorage(trash);
        controllQuality.distributeAtStorages(milk);
        controllQuality.distributeAtStorages(apple);
        controllQuality.distributeAtStorages(appleDiscount);
        controllQuality.distributeAtStorages(bread);

        Food actualResultInWarehouse = warehouse.getStorage()[0];
        Food actualResultInShopWithoutDiscount = shop.getStorage()[0];
        Food actualResultInShopWithDiscount = shop.getStorage()[1];
        Food actualResultInTrash = trash.getStorage()[0];

        assertThat(milk, is(actualResultInWarehouse));
        assertThat(apple, is(actualResultInShopWithoutDiscount));
        assertThat(appleDiscount, is(actualResultInShopWithDiscount));
        assertThat(bread, is(actualResultInTrash));
    }

}