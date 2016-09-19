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
    public void whenMoveBlackPawnForwardOnePositionShouldMove() throws InvalidMoveException {
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

    @Test
    public void whenMoveWhitePawnForwardOnePositionShouldMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 6), "white");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 5);
        board.moveFigure(pawn, newPosition);

        //action
        assertEquals(pawn.getPosition(), newPosition);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMoveBlackPawnForwardMoreThanOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 1), "black");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 3);
        Position newPosition2 = new Position(0, 4);
        Position newPosition3 = new Position(0, 5);
        Position newPosition4 = new Position(0, 6);
        Position newPosition5 = new Position(0, 7);
        board.moveFigure(pawn, newPosition);
        board.moveFigure(pawn, newPosition2);
        board.moveFigure(pawn, newPosition3);
        board.moveFigure(pawn, newPosition4);
        board.moveFigure(pawn, newPosition5);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMoveWhitePawnForwardMoreThanOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 6), "white");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 4);
        Position newPosition2 = new Position(0, 3);
        Position newPosition3 = new Position(0, 2);
        Position newPosition4 = new Position(0, 1);
        Position newPosition5 = new Position(0, 0);
        board.moveFigure(pawn, newPosition);
        board.moveFigure(pawn, newPosition2);
        board.moveFigure(pawn, newPosition3);
        board.moveFigure(pawn, newPosition4);
        board.moveFigure(pawn, newPosition5);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMoveBlackPawnBackOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 1), "black");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 0);
        board.moveFigure(pawn, newPosition);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMoveWhitePawnBackOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 6), "white");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(0, 7);
        board.moveFigure(pawn, newPosition);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMovePawnSidewaysOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(1, 1), "black");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(2, 1);
        Position newPosition2 = new Position(0, 1);
        board.moveFigure(pawn, newPosition);
        board.moveFigure(pawn, newPosition2);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMovePawnDiagonallyOnePositionShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(1, 1), "black");
        board.addFigure(pawn);

        //act
        Position newPosition = new Position(2, 2);
        Position newPosition2 = new Position(0, 2);
        Position newPosition3 = new Position(0, 0);
        Position newPosition4 = new Position(2, 0);
        board.moveFigure(pawn, newPosition);
        board.moveFigure(pawn, newPosition2);
        board.moveFigure(pawn, newPosition3);
        board.moveFigure(pawn, newPosition4);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMovePawnByTheBoardBoundariesShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 0), "white");
        Pawn pawn2 = new Pawn(new Position(0, 7), "black");
        board.addFigure(pawn);
        board.addFigure(pawn2);

        //act
        Position newPosition = new Position(0, -1);
        Position newPosition2 = new Position(0, 8);
        board.moveFigure(pawn, newPosition);
        board.moveFigure(pawn2, newPosition2);
    }

    @Test(expected = InvalidMoveException.class)
    public void whenMovePawnNotOnAnEmptyCellShouldNotMove() throws InvalidMoveException {
        //assign
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(new Position(0, 6), "white");
        Pawn pawn2 = new Pawn(new Position(0, 5), "black");
        board.addFigure(pawn);
        board.addFigure(pawn2);

        //act
        Position newPosition = new Position(0, 5);
        board.moveFigure(pawn, newPosition);
    }

}