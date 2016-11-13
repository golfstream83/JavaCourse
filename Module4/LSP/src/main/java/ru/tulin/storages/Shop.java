package ru.tulin.storages;

import ru.tulin.products.Food;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.11.2016
 */
public class Shop extends Storage {
    /**
     * Product quality determination method
     * @param food
     * @return true or false
     */
    @Override
    public boolean qualityMeets(Food food) {
        if (food.getFreshnessPercentage() >= 0.75 && food.getFreshnessPercentage() < 1) {
            food.setDiscount(0.5);
            return true;
        }
        else if (food.getFreshnessPercentage() >= 0.25 && food.getFreshnessPercentage() < 0.75) {
            return true;
        }
        else return false;
    }
}
