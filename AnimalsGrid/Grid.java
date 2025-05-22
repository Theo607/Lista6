package AnimalsGrid;

public class Grid {
    public int width;
    public int height;
    public String[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void set(Animal animal) {
        grid[animal.position.getX()][animal.position.getY()] = animal.getSpecies();
    }

    public String who(Position position) {
        return grid[position.getX()][position.getY()];
    }

}
