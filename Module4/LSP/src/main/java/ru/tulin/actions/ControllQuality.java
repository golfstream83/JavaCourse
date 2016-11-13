package ru.tulin.actions;

import ru.tulin.products.Food;
import ru.tulin.storages.Storage;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.11.2016
 */
public class ControllQuality {
    /**
     * storage array
     */
    private Storage[] storages = new Storage[10];
    /**
     * storage counter
     */
    int count = 0;

    /**
     * adding a new storage array in
     * @param storage
     */
    void addStorage(Storage storage) {
        for (Storage st : storages) {
            if (st == null) {
                storages[count++] = storage;
                break;
            }
        }
    }

    /**
     * the addition of a certain product in the store, depending on freshness
     * @param food
     */
    void distributeAtStorages(Food food) {
        for (Storage st : storages) {
            if (st.qualityMeets(food)) {
                st.addToStorage(food);
                break;
            }
        }
    }

    /**
     * getter for "storages"
     * @return storages
     */
    public Storage[] getStorages() {
        return storages;
    }
}
