package AnimalsGrid;

public class Setup {
    public Grid grid;
    public Animal[] animals;
    public int numberOfHares;
    public double cycleLength;
    public Generator generator;


    public Setup(int gridWidth, int gridHeight, int numHares, double length) {
        numberOfHares = numHares;
        cycleLength = length;
        generator = new Generator(length);
        animals = new Animal[1+numberOfHares];
        Wolf wolf = new Wolf(generator.getRandomPosition(gridWidth, gridHeight), generator, grid);
        animals[0] = wolf;

        grid = new Grid(gridWidth + 1, gridHeight + 1);
        Animal animal = new Animal(0, 0, generator, grid);
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
            Hare hare = new Hare(generator.getRandomPosition(gridWidth, gridHeight), generator, grid, wolf);
            animals[i + 1] = hare;
            while (grid.who(hare.position) != "empty") {
                hare = new Hare(generator.getRandomPosition(gridWidth, gridHeight), generator, grid, wolf);
            }
            grid.set(hare);
        }
    }

    public String[][] getGrid() {
        return grid.grid;
    }
    public void startSimulation() {
        for (Animal animal : animals) {
            animal.start();
        }
    }
}
