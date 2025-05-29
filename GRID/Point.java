package GRID;

public class Point {
    private int x;
    private int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public Point move(Point point) {
        return new Point(this.x + point.getX(), this.y + point.getY());
    }
}
