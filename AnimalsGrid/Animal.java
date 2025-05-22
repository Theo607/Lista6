package AnimalsGrid;

public class Animal extends Thread {
    public Position position;
    public String species;
    public Generator generator;
    public Grid grid;
    public boolean alive = true;

    public Animal(int x, int y, Generator generator, Grid grid) {
        this.grid = grid;
        this.generator = generator;
        position.setPosition(x, y);
        species = "Animal";
    }

    public double distance(Position position1, Position position2) {
        double x = Math.pow(position1.getX() - position2.getX(), 2);
        double y = Math.pow(position1.getY() - position2.getY(), 2);
        return Math.sqrt(x + y);
    }

    public boolean checkOccupied(Position position) {
        if (grid.who(position) == "empty") {
            return false;
        }

        return true;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getSpecies() {
        return species;
    }

    public void move(int x, int y) {
        position.setPosition(position.getX() + x, position.getY() + y);
    }
}
