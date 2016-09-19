package ru.tulin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 12.09.2016
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for "x"
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for "x"
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for "y"
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
