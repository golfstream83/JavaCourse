package ru.tulin.models;

import org.junit.Test;
import ru.tulin.ChessBoard;
import ru.tulin.InvalidMoveException;
import ru.tulin.Position;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 19.09.2016
 */
public class PawnTest {

    @Test
    public void whenMovePawnForwardOnePosition() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 1), "black");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 2);
        board.moveFigure(pawn, newPosition);

        //action
        assertEquals(pawn.getPosition(), newPosition);
    }

}