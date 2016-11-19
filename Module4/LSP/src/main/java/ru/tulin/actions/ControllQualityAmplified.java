package ru.tulin.actions;

import ru.tulin.products.FoodReproduction;
import ru.tulin.storages.Storage;
import ru.tulin.storages.StorageReproduction;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 17.11.2016
 */
public class ControllQualityAmplified extends ControllQuality {

    /**
     * storage array
     */
    private StorageReproduction[] storages = new StorageReproduction[10];
    /**
     * storage counter
     */
    int count = 0;

    /**
     * adding a new storage array in
     * @param storage
     */
    void addStorageReproduction(StorageReproduction storage) {
        for (StorageReproduction st : storages) {
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
    void distributeAtStoragesReproduction(FoodReproduction food) {
        for (StorageReproduction st : storages) {
            if (st != null && st.qualityMeetsFoodReproduction(food)) {
                st.addToStorageFoodReproduction(food);
                break;
            }
        }
    }

    /**
     * getter for "storages"
     * @return storages
     */
    public StorageReproduction[] getStoragesReproduction() {
        return storages;
    }
}
