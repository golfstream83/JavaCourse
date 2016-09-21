package ru.tulin;

import ru.tulin.models.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 08.09.2016
 */
public class ChessBoard {

    //chess board as an array
    private final Figure[][] board = new Figure[8][8];

    /**
     * method fills the chessboard all figures
     */
    public void fillBoard() {
        this.addFigure(new Rook(new Position(0,0), "black"));
        this.addFigure(new Horse(new Position(1,0), "black"));
        this.addFigure(new Bishop(new Position(2,0), "black"));
        this.addFigure(new Queen(new Position(3,0), "black"));
        this.addFigure(new King(new Position(4,0), "black"));
        this.addFigure(new Bishop(new Position(5,0), "black"));
        this.addFigure(new Horse(new Position(6,0), "black"));
        this.addFigure(new Rook(new Position(7,0), "black"));
        for(int i = 0; i < board[1].length; i++) {
            this.addFigure(new Pawn(new Position(i, 1), "black"));
        }

        this.addFigure(new Rook(new Position(0,7), "white"));
        this.addFigure(new Horse(new Position(1,7), "white"));
        this.addFigure(new Bishop(new Position(2,7), "white"));
        this.addFigure(new Queen(new Position(3,7), "white"));
        this.addFigure(new King(new Position(4,7), "white"));
        this.addFigure(new Bishop(new Position(5,7), "white"));
        this.addFigure(new Horse(new Position(6,7), "white"));
        this.addFigure(new Rook(new Position(7,7), "white"));
        for(int i = 0; i < board[1].length; i++) {
            this.addFigure(new Pawn(new Position(i, 6), "white"));
        }
    }

    /**
     * method adds a figure on a chess board
     * @param figure
     */
    public void addFigure(Figure figure) {
        this.board[figure.getPosition().getY()][figure.getPosition().getX()] = figure;
    }

    /**
     * method removes the figure from the chessboard
     * @param figure
     */
    public void deleteFigure(Figure figure) {
        this.board[figure.getPosition().getY()][figure.getPosition().getX()] = null;
    }

    /**
     * figure method moves into said cell
     * @param figure
     * @param newPosition
     * @throws InvalidMoveException
     */
    public void moveFigure(Figure figure, Position newPosition) throws InvalidMoveException {
        if(checkForCorrectPosition(newPosition) &
                checkNoFiguresOnTheWay(figure, newPosition) &&
                figure.canBeMove(newPosition))
        {
            this.deleteFigure(figure);
            figure.setPosition(newPosition);
            this.addFigure(figure);
        }
    }

    /**
     * method checks the specified cell data for correctness
     * @param position
     * @return true or false
     */
    public boolean checkForCorrectPosition(Position position) throws InvalidMoveException {
        boolean result = false;

        if(position != null &&
                (position.getX() >= 0 && position.getX() <= 7) &&
                (position.getY() >= 0 && position.getY() <= 7)) {
            result = true;
        }
        else {
            throw new InvalidMoveException("The value is outside the boundaries of the board");
        }

        return  result;
    }

    /**
     * method checks whether there are other figures in the way of figure
     * @param figure
     * @param newPosition
     * @return true or false
     */
    public boolean checkNoFiguresOnTheWay(Figure figure, Position newPosition) throws InvalidMoveException {
        boolean result = true;

            if(figure.getPosition().getX() == newPosition.getX() &&
                    figure.getPosition().getY() < newPosition.getY()) {
                for(int i = figure.getPosition().getY() + 1; i <= newPosition.getY(); i++) {
                    if(board[i][figure.getPosition().getX()] != null) {
                        result = false;
                        throw new InvalidMoveException("Such a move is not possible for this figure.");
                    }
                }
            }

        if(figure.getPosition().getX() == newPosition.getX() &&
                figure.getPosition().getY() > newPosition.getY()) {
            for(int i = figure.getPosition().getY() - 1; i >= newPosition.getY(); i--) {
                if(board[i][figure.getPosition().getX()] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
            }
        }

            if(figure.getPosition().getY() == newPosition.getY() &&
                    figure.getPosition().getX() < newPosition.getX()) {
                for(int i = figure.getPosition().getX() + 1; i <= newPosition.getX(); i++) {
                    if(board[figure.getPosition().getY()][i] != null) {
                        result = false;
                        throw new InvalidMoveException("Such a move is not possible for this figure.");
                    }
                }
            }

        if(figure.getPosition().getY() == newPosition.getY() &&
                figure.getPosition().getX() > newPosition.getX()) {
            for(int i = figure.getPosition().getX() - 1; i >= newPosition.getX(); i--) {
                if(board[figure.getPosition().getY()][i] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
            }
        }

        if(figure.getPosition().getY() < newPosition.getY() &&
                figure.getPosition().getX() < newPosition.getX()) {
            for(int i = figure.getPosition().getX() + 1; i <= newPosition.getX(); i++) {
                int j = figure.getPosition().getY() + 1;
                if(board[j][i] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
                j++;
            }
        }

        if(figure.getPosition().getY() > newPosition.getY() &&
                figure.getPosition().getX() < newPosition.getX()) {
            for(int i = figure.getPosition().getX() + 1; i <= newPosition.getX(); i++) {
                int j = figure.getPosition().getY() - 1;
                if(board[j][i] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
                j--;
            }
        }

        if(figure.getPosition().getY() > newPosition.getY() &&
                figure.getPosition().getX() > newPosition.getX()) {
            for(int i = figure.getPosition().getX() - 1; i <= newPosition.getX(); i--) {
                int j = figure.getPosition().getY() - 1;
                if(board[j][i] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
                j--;
            }
        }

        if(figure.getPosition().getY() < newPosition.getY() &&
                figure.getPosition().getX() > newPosition.getX()) {
            for(int i = figure.getPosition().getX() - 1; i <= newPosition.getX(); i--) {
                int j = figure.getPosition().getY() + 1;
                if(board[j][i] != null) {
                    result = false;
                    throw new InvalidMoveException("Such a move is not possible for this figure.");
                }
                j++;
            }
        }

        return result;
    }
    
}
