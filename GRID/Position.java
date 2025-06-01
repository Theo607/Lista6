package GRID;

public class Position {
    private int row;
    private int column;

    public Position(int x, int y) {
        row = x;
        column = y;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public double distanceTo(Position other) {
        return Math.sqrt(Math.pow(row - other.getRow(), 2) + Math.pow(column - other.getColumn(), 2));
    }

    public Position move(Position point) {
        return new Position(row + point.getRow(), column + point.getColumn());
    }
}
