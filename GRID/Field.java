package GRID;

public class Field {
    private Parameters parameters;

    private String[][] field;
    private Point wolfPosition;
    private Point[] harePositions;

    public Field(Parameters parameters) {
        this.parameters = parameters;
        this.field = new String[parameters.getHeight()][parameters.getWidth()];
        this.harePositions = new Point[parameters.getHareCount()];
    }

    public boolean viablePosition(Point position) {
        if (position == null) {
            return true; 
        }
        boolean isValid = true;
        if (position.getX() < 0 || position.getX() >= parameters.getWidth() ||
            position.getY() < 0 || position.getY() >= parameters.getHeight()) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isPositionOccupied(Point position) {
        if (!viablePosition(position)) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        return field[position.getY()][position.getX()] != null;
    }

    public void setPosition(String entity, Point position, boolean clicked) {
        if (!viablePosition(position)) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (clicked) {
            entity += "Clicked";
        }
        field[position.getY()][position.getX()] = entity;
    }

    public String[][] getField() {
        return field;
    }

    public Point getWolfPosition() {
        return wolfPosition;
    }

    public void setWolfPosition(Point wolfPosition, boolean clicked) {
        if (!viablePosition(wolfPosition)) {
            throw new IllegalArgumentException("Wolf position out of bounds");
        }
        if (wolfPosition == null) {
            throw new IllegalArgumentException("Wolf position cannot be null");
        }
        
        if(this.wolfPosition != null) {
            setPosition(null, this.wolfPosition, clicked); // Clear previous position
        }
        this.wolfPosition = wolfPosition;
        setPosition("Wolf", wolfPosition, clicked);
    }

    public void setWolfClicked() {
        if (wolfPosition == null) {
            throw new IllegalStateException("Wolf position is not set");
        }
        setPosition("WolfClicked", wolfPosition, true);
    }

    public void setHareClicked(Hare hare) {
        int index = hare.getIndex();
        if (index < 0 || index >= harePositions.length) {
            throw new IndexOutOfBoundsException("Hare index out of bounds");
        }
        if (harePositions[index] == null) {
            throw new IllegalStateException("Hare position is not set");
        }
        setPosition("HareClicked", harePositions[index], true);
    }

    public Point[] getHarePositions() {
        return harePositions;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public double distanceToWolf(Point harePosition) {
        if (wolfPosition == null) {
            throw new IllegalStateException("Wolf position is not set");
        }
        return distance(harePosition, wolfPosition);
    }

    public void setHarePosition(Hare hare, Point harePosition, boolean clicked) {
        int index = hare.getIndex();
        if (index < 0 || index >= harePositions.length) {
            throw new IndexOutOfBoundsException("Hare index out of bounds");
        }
        if (!viablePosition(harePosition)) {
            throw new IllegalArgumentException("Hare position out of bounds");
        }
        if(harePositions[index] != null) {
            setPosition(null,harePositions[index], clicked); // Clear previous position
        }
        
        harePositions[index] = harePosition;
        setPosition("Hare" , harePosition, clicked);
    }


    
}
