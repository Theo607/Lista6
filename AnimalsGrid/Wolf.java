package AnimalsGrid;

public class Wolf extends Animal {
    public Wolf(Position position) {
        super(position.getX(), position.getY());
        species = "Wolf";
    }
}
