package GRID;

public class Hare extends Thread {
    private Parameters parameters;
    private Field field;

    private int index;
    private boolean alive;
    private Point position;
    private boolean isClicked = false;

    public Hare(Parameters parameters, Field field, int index) {
        this.parameters = parameters;
        this.field = field;
        this.index = index;
        this.alive = true;
        this.position = parameters.getRandomPoint();
        field.setHarePosition(this, position, isClicked);
    }

    public int getIndex() {
        return index;
    }
    public Point getPosition() {
        return position;
    }
    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
        field.setHarePosition(this, position, isClicked); // Update hare position if clicked
    }

    public void kill() {
        alive = false;
    }

    public void hareWait() {
        try {
            Thread.sleep(parameters.getInt((int)Math.floor(parameters.getSpeed() * 0.5), (int)Math.floor(parameters.getSpeed() * 1.5)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

    public void nextMove() {
        if (!alive) {
            return;
        }
        if (isClicked) {
            field.setHarePosition(this, position, isClicked); // Stay in place if clicked
            return;
        } else {
            field.setHarePosition(this, position, false); // Update position without click
        }

        Point[] directions = {
            new Point(0, 1),  
            new Point(0, -1), 
            new Point(1, 0), 
            new Point(-1, 0), 
            new Point(1, 1), 
            new Point(1, -1), 
            new Point(-1, 1), 
            new Point(-1, -1)
        };

        Point[] possibleMoves = new Point[directions.length];
        int i = 0;
        for(Point direction : directions) {
            
            Point newPosition = position.move(direction);
            if (field.viablePosition(newPosition) && !field.isPositionOccupied(newPosition)) {
                possibleMoves[i] = newPosition;
            }
            i++;
        }

        double maxDistance = 0;
        Point[] bestMoves = new Point[possibleMoves.length];
        int bestMoveCount = 0;
        for(Point move : possibleMoves) {
            if (move != null) {
                double distance = field.distanceToWolf(move);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    bestMoveCount = 0;
                    bestMoves = new Point[possibleMoves.length];
                    bestMoves[bestMoveCount++] = move;
                } else if (distance == maxDistance) {
                    bestMoves[bestMoveCount++] = move;
                }
            }
        }
        if (bestMoveCount > 1) {
            int randomIndex = parameters.getInt(0, bestMoveCount - 1);
            Point nextPosition = bestMoves[randomIndex];
            field.setHarePosition(this, nextPosition, isClicked);
            position = nextPosition;
        } else if (bestMoveCount == 1) {
            field.setHarePosition(this, bestMoves[0], isClicked);
            position = bestMoves[0];
        } else {
            field.setHarePosition(this, position, isClicked); // Stay in place if no valid moves
        }
    }

    public void run() {
        while (alive) {
            hareWait();
            nextMove();
        }
    }

}
