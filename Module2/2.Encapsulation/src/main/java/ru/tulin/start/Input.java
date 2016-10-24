package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public interface Input {
    /**
     * method reads the data entered by the user
     * @param question
     * @return
     */
    String ask(String question);

    /**
     * method checks the entered key
     * @param question
     * @param range
     * @return
     * @throws MenuOutException
     */
    int ask(String question, int[] range) throws MenuOutException;
}
