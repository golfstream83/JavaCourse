package ru.tulin.models;

import ru.tulin.InvalidMoveException;
import ru.tulin.Position;


/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.09.2016
 */
public class Pawn extends Figure {

    public Pawn(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean canBeMove(Position newPosition) throws InvalidMoveException {
        boolean result = false;

        if(this.getColor().equals("black")) {
            if(this.getPosition().getX() == newPosition.getX() &&
                    this.getPosition().getY() + 1 == newPosition.getY()) {
                result = true;
            }
            else {
                throw new InvalidMoveException("Such a move is not possible for this figure.");
            }
        }

        if(this.getColor().equals("white")) {
            if(this.getPosition().getX() == newPosition.getX() &&
                    this.getPosition().getY() - 1 == newPosition.getY()) {
                result = true;
            }
            else {
                throw new InvalidMoveException("Such a move is not possible for this figure.");
            }
        }

        return result;
    }
}


