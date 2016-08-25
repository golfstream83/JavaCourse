package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
