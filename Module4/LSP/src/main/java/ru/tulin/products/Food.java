package ru.tulin.products;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.11.2016
 */
public abstract class Food {
    /**
     * food name
     */
    private String name;
    /**
     * date of creation
     */
    private long createDate;
    /**
     * the date of the expiry date
     */
    private long expireDate;
    /**
     * The current date
     */
    private long currentDate;
    /**
     * price of the product
     */
    private double price;
    /**
     * discount on the product
     */
    private double discount;
    /**
     * date formatting template
     */
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Food class constructor
     * @param name
     * @param createData
     * @param expireData
     * @param currentDate
     * @throws ParseException
     */
    public Food(String name, String createData, String expireData, String currentDate) throws ParseException {
        this.name = name;
        this.createDate = format.parse(createData).getTime();
        this.expireDate = format.parse(expireData).getTime();
        this.currentDate = format.parse(currentDate).getTime();
    }

    /**
     * getter for "name"
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for "createDate"
     * @return createDate
     */
    public long getCreateDate() {
        return createDate;
    }

    /**
     * getter for "expireDate"
     * @return expireDate
     */
    public long getExpireDate() {
        return expireDate;
    }

    /**
     * getter for "price"
     * @return price
     */
    public double getPrice() {
        return price*discount;
    }

    /**
     * getter for "discount"
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * setter for "createDate"
     * @param createDate
     * @throws ParseException
     */
    public void setCreateDate(String createDate) throws ParseException {
        this.createDate = format.parse(createDate).getTime();
    }

    /**
     * setter for expireDate"
     * @param expireDate
     * @throws ParseException
     */
    public void setExpireDate(String expireDate) throws ParseException {
        this.expireDate = format.parse(expireDate).getTime();
    }

    /**
     * setter for "currentDate"
     * @param currentDate
     * @throws ParseException
     */
    public void setCurrentDate(String currentDate) throws ParseException {
        this.currentDate = format.parse(currentDate).getTime();
    }

    /**
     * setter for "price"
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * setter for "discount"
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * get a degree of product freshness
     * @return a double value
     */
    public double getFreshnessPercentage() {
        return (currentDate - createDate) / (double)(expireDate - createDate);
    }
}
