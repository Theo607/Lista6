package GRID;

public  class Animal extends Thread {
    private String type;
    private Point position;

    public Animal(String type, Point position) {
        this.type = type;
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public void move(String direction) {
        if (direction.equals("north")) {
            position = new Point(position.getX(), position.getY() - 1);
        } else if (direction.equals("south")) {
            position = new Point(position.getX(), position.getY() + 1);
        } else if (direction.equals("west")) {
            position = new Point(position.getX() - 1, position.getY());
        } else if (direction.equals("east")) {
            position = new Point(position.getX() + 1, position.getY());
        } else if (direction.equals("northeast")) {
            position = new Point(position.getX() + 1, position.getY() - 1);
        } else if (direction.equals("northwest")) {
            position = new Point(position.getX() - 1, position.getY() - 1);
        } else if (direction.equals("southeast")) {
            position = new Point(position.getX() + 1, position.getY() + 1);
        } else if (direction.equals("southwest")) {
            position = new Point(position.getX() - 1, position.getY() + 1);
        } else {
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
