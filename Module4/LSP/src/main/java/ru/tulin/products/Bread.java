package ru.tulin.products;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 05.11.2016
 */
public class Bread extends Food {
    /**
     * Bread class constructor
     * @param name
     * @param createData
     * @param expireData
     * @param currentDate
     * @throws ParseException
     */
    public Bread(String name, String createData, String expireData, String currentDate) throws ParseException {
        super(name, createData, expireData, currentDate);
    }
}
