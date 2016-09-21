package ru.tulin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.09.2016
 */
public class InvalidMoveException extends Exception {

    public InvalidMoveException(String message) {
        super(message);
    }
}
