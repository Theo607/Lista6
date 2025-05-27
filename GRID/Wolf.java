package GRID;

public class Wolf extends Animal {
    private static final String TYPE = "wolf";

    public Wolf(Point position) {
        super(TYPE, position);
    }

    @Override
    public void move(String direction) {
        super.move(direction);
    }

    @Override
    public String getType() {
        return TYPE;
    }
    
}
