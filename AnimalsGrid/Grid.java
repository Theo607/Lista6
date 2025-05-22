package AnimalsGrid;

public class Grid {
    public int width;
    public int height;
    public String[][] grid;
    public Animal[] animals;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = "empty";
            }
        }
    }

    public void set(Animal animal) {
        grid[animal.position.getX()][animal.position.getY()] = animal.getSpecies();
    }

    public String who(Position position) {
        return grid[position.getX()][position.getY()];
    }

}
