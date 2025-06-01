package GRID;

import java.util.Random;

public class Rng {
    private Random random;

    public Rng() {
        this.random = new Random();
    }

    public int getInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Max must be greater than min");
        } else if (min == max) {
            return min; // If min and max are equal, return min
        }
        
        return random.nextInt(max - min) + min;
    }

    public Position getRandomPosition(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        int row = getInt(0, height);
        int column = getInt(0, width);
        return new Position(row, column);
    }
}
