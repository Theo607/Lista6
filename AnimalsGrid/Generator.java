package AnimalsGrid;

import java.util.Random;

public class Generator {
    private double cycleLenght = 1;
    private double cycle;
    private double randomNumber = 0;
    private Random random = new Random();
    
    public Generator(double number) {
        cycleLenght = number;
    }

    public void setCycleLength(double length) {
        cycleLenght = length;
    }

    private void setRandomNumber() {
        randomNumber = random.nextDouble();
    }
    private void setCycle() {
        setRandomNumber();
        cycle = (randomNumber + 0.5 ) * cycleLenght;
    }

    public double getCycle() {
        setCycle();
        return cycle;
    }

    public Position getRandomPosition(int maxWidth, int maxHeight) {
        setRandomNumber();
        int x = (int)Math.floor(randomNumber * 10) % maxWidth;
        setRandomNumber();
        int y = (int)Math.floor(randomNumber * 10) % maxHeight;

        x = Math.abs(x);
        y = Math.abs(y);

        return new Position(x, y);
    }
}