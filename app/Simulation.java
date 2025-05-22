package app;


import AnimalsGrid.*;
import Visuals.*;

public class Simulation {
    public static void main(String[] args) {
        try{
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);
            Setup setup = new Setup(n, m, 10, k);
            setup.startSimulation();
            Wolf wolf = (Wolf) setup.animals[0];
            //main drawing loop
            while(wolf.winStatus == false){}
        } catch (Exception e) {
            System.out.println("Invalid input. Please provide three integers.");
            return;
        }
    }
}
