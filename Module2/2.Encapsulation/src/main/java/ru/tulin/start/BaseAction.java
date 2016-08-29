package ru.tulin.start;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 29.08.2016
 */
public abstract class BaseAction implements UserAction {
    private String name;

    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * method creates a string with a number and the name of the menu
     * @return the number and name of the menu item
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
