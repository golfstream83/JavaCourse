package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public interface Input {

    String ask(String question);

    int ask(String question, int[] range) throws MenuOutException;
}
