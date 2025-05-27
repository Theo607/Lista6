package GRID;

import java.util.Random;

public class Rng {
    private Random random;

    public Rng() {
        this.random = new Random();
    }

    public int getInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return random.nextInt(max - min) + min;
    }

    public Point getRandomPoint(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        return new Point(getInt(0, width), getInt(0, height));
    }
}
