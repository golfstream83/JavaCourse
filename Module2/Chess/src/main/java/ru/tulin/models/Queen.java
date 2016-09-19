package ru.tulin.models;

import ru.tulin.InvalidMoveException;
import ru.tulin.Position;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.09.2016
 */
public class Queen extends Figure {

    public Queen(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean canBeMove(Position newPosition) throws InvalidMoveException {
        boolean result = false;

        if(this.getPosition().getX() == newPosition.getX() &&
                    this.getPosition().getY() < newPosition.getY() ||
                    this.getPosition().getY() > newPosition.getY()) {
                result = true;
            }
            else {
                throw new InvalidMoveException("Such a move is not possible for this figure.");
            }

        if(this.getPosition().getY() == newPosition.getY() &&
                this.getPosition().getX() < newPosition.getX() ||
                this.getPosition().getX() > newPosition.getX()) {
            result = true;
        }
        else {
            throw new InvalidMoveException("Such a move is not possible for this figure.");
        }

        if(Math.abs(this.getPosition().getY() - newPosition.getY()) ==
                Math.abs(this.getPosition().getX() - newPosition.getX())) {
            result = true;
        }
        else {
            throw new InvalidMoveException("Such a move is not possible for this figure.");
        }

        return result;
    }
}
