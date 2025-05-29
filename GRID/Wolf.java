package GRID;

public class Wolf extends Thread{
    private Parameters parameters;
    private Field field;

    private Point position;
    private boolean won = false;
    private boolean isClicked = false;

    public Wolf(Parameters parameters, Field field) {
        this.parameters = parameters;
        this.field = field;
        this.position = parameters.getRandomPoint();
        field.setWolfPosition(this.position, isClicked);
    }

    public Point getPosition() {
        return position;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }


}
