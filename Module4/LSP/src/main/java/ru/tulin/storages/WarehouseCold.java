package ru.tulin.storages;

import ru.tulin.products.Food;
import ru.tulin.products.FoodReproduction;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 17.11.2016
 */
public class WarehouseCold extends StorageReproduction {

    /**
     * product quality determination method
     * @param food
     * @return true or false
     */
    @Override
    public boolean qualityMeetsFoodReproduction(FoodReproduction food) {
        boolean result = false;

        if (food.getFreshnessPercentage() < 0.25 && food.getIfVegetable()) {
            result = true;
        }
        else if (food.getFreshnessPercentage() >= 1 && food.isCanReproduct()) {
            result = true;
        }
        return result;
    }

    /**
     * product quality determination method
     * @param food
     * @return
     */
    @Override
    public boolean qualityMeets(Food food) {
        return false;
    }
}
