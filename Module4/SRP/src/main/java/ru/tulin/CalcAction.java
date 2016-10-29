package ru.tulin;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public abstract class CalcAction {


    /**
     * the name of the menu item
     */
    private String name;

    public CalcAction(String name) {
        this.name = name;
    }

    /**
     * obtaining a key method
     * @return
     */
    abstract int key();

    /**
     * start calculation method
     * @param input
     * @param tracker
     * @param print
     */
    abstract void execute(ConsoleInput input, Calculator tracker, Print print);

    /**
     * getter for "name"
     * @return name
     */
    public String getName() {
        return name;
    }
}
