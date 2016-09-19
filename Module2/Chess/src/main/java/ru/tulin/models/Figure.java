package ru.tulin.models;

import ru.tulin.InvalidMoveException;
import ru.tulin.Position;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 08.09.2016
 */
public abstract class Figure {
    Position position;
    String color;

    public Figure(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    /**
     * Getter for "position"
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter for "position"
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Getter for "color"
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for "color"
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * method checks whether the figure can be placed in the cell according to the logic of its motion
     * @param position
     * @return
     * @throws InvalidMoveException
     */
    public abstract boolean canBeMove(Position position) throws InvalidMoveException;
}
