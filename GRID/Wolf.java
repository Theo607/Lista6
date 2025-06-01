package GRID;

public class Wolf extends Animal {

    public Wolf(Field field) {
        super(field, new AnimalState(0, "Wolf"));
        if (field == null) {
            throw new IllegalArgumentException("Field cannot be null");
        }
    }

    @Override
    public void nextMove() {
        if(getAnimalState().isClicked()) {
            System.out.println("Wolf " + getAnimalState().getIndex() + " clicked: " + getAnimalState().isClicked() + 
                               " at position (" + getField().getPositions()[getAnimalState().getIndex()].getRow() + 
                               ", " + getField().getPositions()[getAnimalState().getIndex()].getColumn() + ")" + " " + getAnimalState().getType());
        }
    }
    
}
