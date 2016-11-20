package ru.tulin.storages;

import ru.tulin.products.Food;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 17.11.2016
 */
public class WarehouseAddl extends Warehouse {
    /**
     * Product quality determination method
     * @param food
     * @return true or false
     */
    @Override
    public boolean qualityMeets(Food food) {
        return super.qualityMeets(food);
    }
}
