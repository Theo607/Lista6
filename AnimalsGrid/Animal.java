package AnimalsGrid;

public class Animal {
    public Position position;
    public String species;

    public Animal(int x, int y) {
        position.setPosition(x, y);
        species = "Animal";
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
