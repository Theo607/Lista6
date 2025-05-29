package GRID;

public class Parameters {
    private int width;
    private int height;
    private int speed;
    private int hareCount;
    private Rng rng;

    public Parameters(int width, int height, int speed, int hareCount, Rng rng) {
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.hareCount = hareCount;
        this.rng = rng;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getSpeed() {
        return speed;
    }

    public int getHareCount() {
        return hareCount;
    }

    public Point getRandomPoint() {
        return rng.getRandomPoint(height, width);
    }

    public int getInt(int min, int max) {
        return rng.getInt(min, max);
    }




    
}
