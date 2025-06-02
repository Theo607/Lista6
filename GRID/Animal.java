package GRID;

public class Animal extends Thread {
    private AnimalState state;
    private Position position;
    private Field field;
    
    public Animal(AnimalState state, Position position) {
        this.state = state;
        this.position = position;
    }

    public boolean animalIsAlive() {
        return state.lives();
    }

    public boolean animalIsClicked() {
        return state.isClicked();
    }

    public void killAnimal() {
        state.dead();
    }

    public void deleteAnimal() {
        field.killAnimal(state.getIndex());
    }

    public void gameEnded() {
        field.gameEnded();
    }

    public Position getPosition() {
        return position;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public AnimalState getAnimalState() {
        return state;
    }

    public int getInt(int min, int max) {
        return field.getInt(min, max);
    }

    public void sleep() {
        try {
            Thread.sleep(field.getCycle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isInBounds(Position position) {
        return field.inBounds(position);
    }

    public boolean isPositionOccupied(Position position) {
        return field.isPositionOccupied(position);
    }

    public void updatePosition(Position newPosition) {
        field.updatePosition(state.getIndex(), newPosition);
        this.position = newPosition;
    }

    public void nextMove() {}

    public void run() {
        while (state.lives()) {
            sleep();
            nextMove();
        }
    }
}
