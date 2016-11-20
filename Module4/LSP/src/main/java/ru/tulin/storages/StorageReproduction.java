package ru.tulin.storages;

import ru.tulin.products.FoodReproduction;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 19.11.2016
 */
public abstract class StorageReproduction extends Storage {

    /**
     * array of products
     */
    private FoodReproduction[] storage = new FoodReproduction[10];

    /**
     * counter products in an array
     */
    int count = 0;

    /**
     * Product quality determination method
     * @param food
     * @return
     */
    public abstract boolean qualityMeetsFoodReproduction(FoodReproduction food);

    /**
     * adding products to an array
     * @param food
     */
    public void addToStorageFoodReproduction(FoodReproduction food) {
        if (count < storage.length) {
            storage[count++] = food;
        }
    }

    /**
     * getter for "storage"
     * @return storage
     */

    public FoodReproduction[] getStorageFoodReproduction() {
        return storage;
    }
}
