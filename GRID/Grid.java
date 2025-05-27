package GRID;

import java.util.Vector;

public class Grid {
    private int width;
    private int height;
    private int numberOfHares;
    private String[][] cellTypes;
    private static String[] baseCellTypes = {"", "wolf", "hare"};
    private Rng rng;
    private Wolf wolf;
    private Vector<Hare> hares;

    public Grid(int width, int height, int hareNumber, Rng rng) {
        this.width = width;
        this.height = height;
        this.cellTypes = new String[height][width];
        this.rng = rng;
        this.numberOfHares = hareNumber;
        Wolf wolf = new Wolf(rng.getRandomPoint(width, height));
        cellTypes[wolf.getPosition().getY()][wolf.getPosition().getX()] = wolf.getType();
        this.wolf = wolf;
        this.hares = new Vector<>();
        for(int i = 0; i < numberOfHares; i++) {
            Point harePosition = rng.getRandomPoint(width, height);
            while (cellTypes[harePosition.getY()][harePosition.getX()] != null) {
                harePosition = rng.getRandomPoint(width, height);
            }
            Hare hare = new Hare(harePosition);
            hares.add(hare);
            cellTypes[harePosition.getY()][harePosition.getX()] = hare.getType();
        }
    }

    public void start() {
        wolf.start();
        for(Hare hare : hares) {
            hare.start();
        }
    }

    public void updateGrid() {
        cellTypes = new String[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cellTypes[i][j] = baseCellTypes[0];
            }
        }
        Point wolfPosition = wolf.getPosition();
        cellTypes[wolfPosition.getY()][wolfPosition.getX()] = wolf.getType();
        for(Hare hare : hares) {
            Point harePosition = hare.getPosition();
            cellTypes[harePosition.getY()][harePosition.getX()] = hare.getType();
        }
    }

    public boolean haresLeft() {
        if(hares.isEmpty()) {
            return false;
        }

        return true;
    }

    public String[][] getCellTypes() {
        return cellTypes;
    }
}