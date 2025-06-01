package GRID;

public class Animal extends Thread {
    private Field field;
    private AnimalState state;

    public Animal(Field field, AnimalState state) {
        if (field == null || state == null) {
            throw new IllegalArgumentException("Field and State cannot be null");
        }
        this.field = field;
        this.state = state;
    }

    public Field getField() {
        return field;
    }

    public void sleep() {
        try {
            Thread.sleep(field.cycle()); // Sleep for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
    }

    public void kill() {
        this.state.kill();

    }
    public AnimalState getAnimalState() {
        return state;
    }

    public void nextMove() {
    }

    public void run() {
        while(state.lives()) {
            sleep();
            nextMove();
        }
    }
    
}
