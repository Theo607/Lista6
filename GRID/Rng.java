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
}
