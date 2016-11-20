package ru.tulin.products;

import java.text.ParseException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 15.11.2016
 */
public abstract class FoodReproduction extends Food {

    /**
     * for the value of the processing capabilities of the product
     */
    private boolean canReproduct;

    /**
     * it contains the value of the product is a vegetable or not
     */
    private boolean ifVegetable = false;

    /**
     * FoodReproduction class constructor
     * @param name
     * @param createData
     * @param expireData
     * @param currentDate
     * @throws ParseException
     */
    public FoodReproduction(String name, String createData, String expireData, String currentDate) throws ParseException {
        super(name, createData, expireData, currentDate);
    }

    /**
     * getter for "canReproduct"
     * @return true or false
     */
    public boolean isCanReproduct() {
        return this.canReproduct;
    }

    /**
     * getter for "ifVegetable"
     * @return
     */
    public boolean getIfVegetable() {
        return ifVegetable;
    }

    /**
     * setter for "canReproduct"
     * @param canReproduct
     */
    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    /**
     * setter for "ifVegetable"
     * @param ifVegetable
     */
    public void setIfVegetable(boolean ifVegetable) {
        this.ifVegetable = ifVegetable;
    }
}
