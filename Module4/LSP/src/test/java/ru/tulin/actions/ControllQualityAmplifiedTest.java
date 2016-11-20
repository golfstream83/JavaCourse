package ru.tulin.actions;

import org.junit.Before;
import org.junit.Test;
import ru.tulin.products.Carrot;
import ru.tulin.products.FoodReproduction;
import ru.tulin.storages.WarehouseCold;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 19.11.2016
 */
public class ControllQualityAmplifiedTest {

    ControllQualityAmplified controllQualityAmplified = new ControllQualityAmplified();
    WarehouseCold warehouseCold = new WarehouseCold();
    Carrot carrot;
    Carrot carrotDefective;

    @Before
    public void init() throws ParseException {

        String createDateCarrot = "01.11.2016";
        String createDateCarrotDefective = "01.08.2016";
        String expireDateCarrot = "30.11.2016";
        String expireDateCarrotDefective = "01.11.2016";
        String currentDate = "02.11.2016";
        carrot = new Carrot("carrot", createDateCarrot, expireDateCarrot, currentDate);
        carrotDefective = new Carrot("carrot", createDateCarrotDefective, expireDateCarrotDefective, currentDate);

    }

    @Test
    public void whenAddCanBeReproductProductToWarehouseColdThenTrue() {

        controllQualityAmplified.addStorageReproduction(warehouseCold);
        carrotDefective.setIfVegetable(true);
        carrotDefective.setCanReproduct(true);
        controllQualityAmplified.distributeAtStoragesReproduction(carrotDefective);

        FoodReproduction actualResultInWarehouseCold = warehouseCold.getStorageFoodReproduction()[0];

        assertThat(carrotDefective, is(actualResultInWarehouseCold));
    }

    @Test
    public void whenAddVegetableToWarehouseColdThenTrue() {

        controllQualityAmplified.addStorageReproduction(warehouseCold);
        carrot.setIfVegetable(true);
        controllQualityAmplified.distributeAtStoragesReproduction(carrot);

        FoodReproduction actualResultInWarehouseCold = warehouseCold.getStorageFoodReproduction()[0];

        assertThat(carrot, is(actualResultInWarehouseCold));
    }

    @Test
    public void whenAddNotVegetableToWarehouseColdThenFalse() {

        controllQualityAmplified.addStorageReproduction(warehouseCold);
        carrot.setIfVegetable(false);
        controllQualityAmplified.distributeAtStoragesReproduction(carrot);

        FoodReproduction actualResultInWarehouseCold = warehouseCold.getStorageFoodReproduction()[0];

        assertNull(actualResultInWarehouseCold);
    }

}