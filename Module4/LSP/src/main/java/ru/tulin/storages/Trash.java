package ru.tulin.storages;

import ru.tulin.products.Food;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.11.2016
 */
public class Trash extends Storage {
    /**
     * Product quality determination method
     * @param food
     * @return true or false
     */
    @Override
    public boolean qualityMeets(Food food) {
        if (food.getFreshnessPercentage() >= 1) {
            return true;
        }
        else return false;
    }
}
