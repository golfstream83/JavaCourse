package ru.tulin.start;

import ru.tulin.models.Item;
import java.util.Random;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * method creates a new item and places it in the array of items
     * @param item
     * @return new item
     */
    protected Item addItem(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * method edit item
     * @param fresh
     */
    protected void editItem(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }
    }

    /**
     * remove the item method
     */
    protected void deleteItem(String id) {
        //assign null array element
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = null;
                break;
            }
        }
        //group the not null items at the beginning of the array
        for (int index = 0; index < items.length - 1; index++) {
            if (items[index] == null) {
                for (int j = index + 1; j < items.length; j++) {
                    if (items[j] != null) {
                        items[index] = items[j];
                        items[j] = null;
                        break;
                    }
                }
            }
        }
        //reduce the length of the array of items
        this.position--;
    }

    /**
     * method creates an array of all the items in the tracker
     * @return an array of items
     */
    protected Item[] showAllItem() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * method creates an array of items whose name contains the word "name"
     * @param name
     * @return result array
     */
    protected Item[] filteredByName(String name) {
        Item result[] = new Item[this.position];
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getName().contains(name)) {
                result[index] = items[index];
            }
        }
        return result;
    }


    /**
     * method generates an id number
     * @return id number
     */
    protected String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * item search method by id
     * @param id
     * @return result
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
