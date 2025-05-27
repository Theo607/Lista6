package GRID;

public class Hare extends Animal {
    private static final String TYPE = "hare";

    public Hare(Point position) {
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
