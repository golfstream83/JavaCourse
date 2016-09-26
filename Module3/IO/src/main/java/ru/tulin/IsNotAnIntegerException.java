package ru.tulin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.09.2016
 */
public class IsNotAnIntegerException extends Exception {
    public IsNotAnIntegerException(String message) {
        super(message);
    }
}
