package ru.tuin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 30.10.2016
 */
public class EngineerCalculator extends Calculator {

    /**
     * sine of the angle
     * @param number
     * @return
     */
    public double sinus(double number) {
        return Math.sin(number);
    }

    /**
     * cosine of the angle
     * @param number
     * @return
     */
    public double cosine(double number) {
        return Math.cos(number);
    }

}
