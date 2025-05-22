package AnimalsGrid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;

public class Wolf extends Animal {
    public boolean winStatus = false;
    public Wolf(Position position, Generator generator, Grid grid) {
        super(position.getX(), position.getY(), generator, grid);
        species = "Wolf";
    }

    public Position getPosition() {
        return position;
    }

    public Hare NearestHare() {
        List<Hare> nearestHares = new ArrayList<>();
        double smallestDistance = Double.MAX_VALUE;
        for (Animal animal : grid.animals) {
            if (animal.getSpecies() == "Hare" && distance(position, animal.getPosition()) <= smallestDistance) {
                nearestHares.add((Hare) animal);
                if (distance(position, animal.getPosition()) < smallestDistance) {
                    smallestDistance = distance(position, animal.getPosition());
                }
            }
        }
        if (nearestHares.isEmpty()) {
            return null;
        }
        for (Animal animal : nearestHares) {
            if (distance(position, animal.getPosition()) > smallestDistance) {
                nearestHares.remove(animal);
            }
        }
        return nearestHares.get(generator.getRandomNumber(nearestHares.size()));
    }

    public void nextMove() {
        Hare hare = NearestHare();
        if (hare == null) {
            winStatus = true;
            return;
        }
        if (distance(position, hare.position) == 1) {
            hare.alive = false;
            position.setPosition(hare.position.getX(), hare.position.getY());
            grid.set(this);
            return;
        }
        List<Position> occupied = new ArrayList<>();
        // 0 1 2 ^ height [-1,1] [0,1] [1,1]
        // 3 4 | [-1,0] [0,0] [1,0]
        // 5 6 7 |___> width [-1,-1] [0,-1] [1,-1]
        occupied.add(new Position(this.position.getX() - 1, this.position.getY() + 1));
        occupied.add(new Position(this.position.getX(), this.position.getY() + 1));
        occupied.add(new Position(this.position.getX() + 1, this.position.getY() + 1));
        occupied.add(new Position(this.position.getX() - 1, this.position.getY()));
        occupied.add(new Position(this.position.getX(), this.position.getY()));
        occupied.add(new Position(this.position.getX() + 1, this.position.getY()));
        occupied.add(new Position(this.position.getX() - 1, this.position.getY() - 1));
        occupied.add(new Position(this.position.getX(), this.position.getY() - 1));

        Iterator<Position> iterator = occupied.iterator();
        while (iterator.hasNext()) {
            Position pos = iterator.next();
            if (grid.who(pos) != "empty") {
                iterator.remove();
            }
        }

        double smallestDistance = Double.MAX_VALUE;
        for(Position pos : occupied) {
            if (distance(pos, hare.position) < smallestDistance) {
                smallestDistance = distance(pos, hare.position);
            }
        }

        iterator = occupied.iterator();
        while (iterator.hasNext()) {
            Position pos = iterator.next();
            if (distance(pos, hare.position) > smallestDistance) {
                iterator.remove();
            }
        }

        position = occupied.get(generator.getRandomNumber(occupied.size()));
        grid.set(this);
    }

    @Override
    public void run() {
        try {
            while (alive) {
                Thread.sleep((long) generator.getCycle());
                nextMove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
