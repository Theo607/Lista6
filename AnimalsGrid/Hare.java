package AnimalsGrid;

import java.util.ArrayList;
import java.util.List;

public class Hare extends Animal {
    public Position wolfPosition;
    public Wolf wolf;

    public Hare(Position position, Generator generator, Grid grid, Wolf wolf) {
        super(position.getX(), position.getY(), generator, grid);
        species = "Hare";
    }

    public void nextMove() {
        Boolean[] occupied = new Boolean[8];
        //0 1 2  ^ height     [-1,1] [0,1] [1,1]
        //3   4  |            [-1,0] [0,0] [1,0]
        //5 6 7  |___> width  [-1,-1] [0,-1] [1,-1]
        Position[] position = new Position[8];
        position[0] = new Position(this.position.getX()-1, this.position.getY()+1);
        position[1] = new Position(this.position.getX(), this.position.getY()+1);
        position[2] = new Position(this.position.getX()+1, this.position.getY()+1);
        position[3] = new Position(this.position.getX()-1, this.position.getY());
        position[4] = new Position(this.position.getX(), this.position.getY());
        position[5] = new Position(this.position.getX()+1, this.position.getY());
        position[6] = new Position(this.position.getX()-1, this.position.getY()-1);
        position[7] = new Position(this.position.getX(), this.position.getY()-1);

        int notOccupied = 0;
        for(int i = 0; i < 8; i++) {
            occupied[i] = checkOccupied(position[i]);
            if (occupied[i] == false) {
                notOccupied = notOccupied + 1;
            }
        }

        if (notOccupied == 0) {
            return;
        }

        double[] distance = new double[notOccupied];
        double smallestDistance = distance(position[0], wolfPosition);

        wolfPosition = wolf.getPosition();
        for(int i = 0; i < 8; i++) {
            if(occupied[i] == false) {
                distance[i] = distance(position[i], wolfPosition);
                if(distance[i] < smallestDistance) {
                    smallestDistance = distance[i];
                }
            }
        }

       List<Integer> moves = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            if(occupied[i] == false && distance[i] == smallestDistance) {
                moves.add(i);
            }
        }
        int move = moves.get((int)generator.getRandomNumber(moves.size()));
        switch(move) {
            case 0:
                move(-1, 1);
                break;
            case 1:
                move(0, 1);
                break;
            case 2:
                move(1, 1);
                break;
            case 3:
                move(-1, 0);
                break;
            case 4:
                move(0, 0);
                break;
            case 5:
                move(1, 0);
                break;
            case 6:
                move(-1, -1);
                break;
            case 7:
                move(0, -1);
                break;
        }
        grid.set(this);
    }

    @Override
    public void run() {
        try {
            while(alive == true) {
                long sleepTime = (long)Math.floor(generator.getCycle())+1;
                Hare.sleep(sleepTime);
                nextMove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
