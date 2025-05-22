package AnimalsGrid;

public class Wolf extends Animal {
    public Wolf(Position position, Generator generator, Grid grid) {
        super(position.getX(), position.getY(), generator, grid);
        species = "Wolf";
    }
    
    public Position getPosition() {
        return position;
    }

    public void nextMove() {
        
    }

    @Override
    public void run() {
        try {
            while (alive) {
                Thread.sleep((long) generator.getCycle());
                nextMove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
