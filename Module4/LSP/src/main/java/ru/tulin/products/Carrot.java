package ru.tulin.products;

import java.text.ParseException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 17.11.2016
 */
public class Carrot extends FoodReproduction {
    /**
     * FoodReproduction class constructor
     *
     * @param name
     * @param createData
     * @param expireData
     * @param currentDate
     * @throws ParseException
     */
    public Carrot(String name, String createData, String expireData, String currentDate) throws ParseException {
        super(name, createData, expireData, currentDate);
    }
}
