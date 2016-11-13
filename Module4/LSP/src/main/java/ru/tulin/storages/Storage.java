package ru.tulin.storages;

import ru.tulin.products.Food;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 05.11.2016
 */
public abstract class Storage {
    /**
     * array of products
     */
    private Food[] storage = new Food[10];
    /**
     * counter products in an array
     */
    int count = 0;

    public void addToStorage(Food food) {
        if (count < storage.length) {
           storage[count++] = food;
        }
    }

    /**
     * Product quality determination method
     * @param food
     * @return
     */
    public abstract boolean qualityMeets (Food food);

    /**
     * getter for "storage"
     * @return storage
     */
    public Food[] getStorage() {
        return storage;
    }
}
