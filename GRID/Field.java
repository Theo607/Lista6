package GRID;

public class Field {
    private Parameters parameters;
    private Position[] positions; //positions[index] (row, column)
    private int[][] indexes; //indexes[row][column] = index
    private AnimalState[] states; //states[index] = State object
    
    public Field(Parameters parameters) {
        this.parameters = parameters;
        int width = parameters.getWidth();
        int height = parameters.getHeight();
        positions = new Position[width * height];
        indexes = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                indexes[i][j] = -1; // Initialize all positions as free
            }
        }
        states = new AnimalState[width * height];
    }

    public int cycle() {
        int speed = parameters.getSpeed();
        return parameters.getInt((int)Math.floor(speed * 0.5), (int)Math.floor(speed * 1.5));
    }

    public int getRandomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Min must be less than max");
        }
        return parameters.getInt(min, max);
    }

    public Position getRandomPosition() {
        return parameters.getRandomPosition();
    }

    public void addAnimal(Animal animal, int index) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null");
        }
        if (index < 0 || index >= states.length) {
            throw new IndexOutOfBoundsException("Position out of bounds for the field");
        }
        
        Position randomPosition = getRandomPosition();
        while(!isPositionFree(randomPosition)) {
            randomPosition = getRandomPosition();
        }

        positions[index] = randomPosition; // Set the position for the animal
        indexes[randomPosition.getRow()][randomPosition.getColumn()] = index; // Update the index for the position
        states[index] = animal.getAnimalState(); // Set the state for the animal
    }

    public AnimalState[] getStates() {
        return states;
    }

    public Position[] getPositions() {
        return positions;
    }

    public int[][] getIndexes() {
        return indexes;
    }

    public Position getPosition(int index) {
        if (index < 0 || index >= positions.length) {
            throw new IndexOutOfBoundsException("Index out of bounds for the field");
        }
        return positions[index];
    }

    public void reposition(int index, Position position) {
        if(position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (index < 0 || index >= states.length) {
            throw new IndexOutOfBoundsException("Index out of bounds for the field");
        }
        indexes[positions[index].getRow()][positions[index].getColumn()] = -1; // Clear old position
        positions[index] = position; // Update position
        indexes[position.getRow()][position.getColumn()] = index; // Set new position
    }

    public boolean isPositionFree(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (position.getRow() < 0 || position.getRow() >= parameters.getHeight() || 
            position.getColumn() < 0 || position.getColumn() >= parameters.getWidth()) {
            throw new IndexOutOfBoundsException("Position out of bounds for the field");
        }
        return indexes[position.getRow()][position.getColumn()] == -1;
    }

    public boolean inBounds(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return position.getRow() >= 0 && position.getRow() < parameters.getHeight() &&
               position.getColumn() >= 0 && position.getColumn() < parameters.getWidth();
    }

}
