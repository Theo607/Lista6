package AnimalsGrid;

public class Setup {
    public Grid grid;
    int numberOfHares;
    double cycleLength;
    Generator generator;

    public Setup(int gridWidth, int gridHeight, int numHares, double length) {
        numberOfHares = numHares;
        cycleLength = length;
        generator = new Generator(length);
        Wolf wolf = new Wolf(generator.getRandomPosition(gridWidth, gridHeight));

        grid = new Grid(gridWidth + 1, gridHeight + 1);
        Animal animal = new Animal(0, 0);
        for(int i = 0; i < gridWidth + 1; i++) {
            animal.setPosition(new Position(i, 0));
            grid.set(animal);
            animal.setPosition(new Position(i, gridHeight));
            grid.set(animal);
        }
        for(int i = 0; i < gridHeight + 1; i++) {
            animal.setPosition(new Position(0, i));
            grid.set(animal);
            animal.setPosition(new Position(gridWidth, i));
            grid.set(animal);
        }
        grid.set(wolf);

        for (int i = 0; i < numberOfHares; i++) {
            Hare hare = new Hare(generator.getRandomPosition(gridWidth, gridHeight));
            while (grid.who(hare.position) != null) {
                hare = new Hare(generator.getRandomPosition(gridWidth, gridHeight));
            }
            grid.set(hare);
        }

    }

    public Grid getGrid() {
        return grid;
    }
}
