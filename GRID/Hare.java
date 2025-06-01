package GRID;

public class Hare extends Animal {

    public Hare(int index, Field field) {
        super(field, new AnimalState(index, "Hare"));
        if (field == null) {
            throw new IllegalArgumentException("Field cannot be null");
        }
    }

    @Override
    public void nextMove() {
        // Implement the logic for the hare's next move
        // This could involve checking surrounding positions and moving to a free position
        // For now, we will just print a message indicating the hare is moving
        if(getAnimalState().isClicked()) {
            sleep();
        } else {
            Position currentPosition = getField().getPositions()[getAnimalState().getIndex()];
            Position wolfPosition = getField().getPosition(0);
            Position[] possibleMoves = {
                new Position(currentPosition.getRow() - 1, currentPosition.getColumn()), 
                new Position(currentPosition.getRow() + 1, currentPosition.getColumn()), 
                new Position(currentPosition.getRow(), currentPosition.getColumn() - 1), 
                new Position(currentPosition.getRow(), currentPosition.getColumn() + 1),
                new Position(currentPosition.getRow() - 1, currentPosition.getColumn() - 1),
                new Position(currentPosition.getRow() - 1, currentPosition.getColumn() + 1),
                new Position(currentPosition.getRow() + 1, currentPosition.getColumn() - 1),
                new Position(currentPosition.getRow() + 1, currentPosition.getColumn() + 1)
            };
            double maxDistance = -1.0;
            int bestMovesCount = 0;
            Position[] bestMoves = new Position[8];
            for (Position move : possibleMoves) {
                if (!getField().inBounds(move) || !getField().isPositionFree(move)) {
                    move = null;
                } else if(wolfPosition.distanceTo(move) > maxDistance) {
                    maxDistance = wolfPosition.distanceTo(move);
                    bestMovesCount = 0;
                    bestMoves = new Position[8];
                    bestMoves[bestMovesCount++] = move;
                } else if (wolfPosition.distanceTo(move) == maxDistance) {
                    bestMoves[bestMovesCount++] = move;
                }
            }
            if (bestMovesCount > 0) {
                int randomIndex = getField().getRandomInt(0, bestMovesCount);
                Position bestMove = bestMoves[randomIndex];
                getField().reposition(getAnimalState().getIndex(), bestMove);
            } else {
                sleep();
            }
        }
    }
    
}
