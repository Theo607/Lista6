package GRID;

public class Grid {
    private int width;
    private int height;
    private String[][] cellTypes;
    private static String[] baseCellTypes = {"", "wolf", "hare"};
    private Rng rng;

    public Grid(int width, int height, Rng rng) {
        this.width = width;
        this.height = height;
        this.cellTypes = new String[height][width];
        this.rng = rng;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cellTypes[i][j] = baseCellTypes[rng.getInt(0, baseCellTypes.length)];
            }
        }
    }

    public String[][] getCellTypes() {
        return cellTypes;
    }
}