package ru.tulin.models;

import ru.tulin.Figure;
import ru.tulin.Position;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.09.2016
 */
public class Rook extends Figure {

    public Rook(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean canBeMove(Position position) {
        boolean result = false;
        return result;
    }
}
