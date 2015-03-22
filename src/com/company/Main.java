package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Spot tabHotFoodSpot[];
        Spot tabSandSpot[];
        Spot tabDrinkSpot[];
        Spot tabCashierSpot[];
        ArrayList <Person> tabOfPersons[];

        //simulation total time
        int howManyIterations = 5400;
        Random rn = new Random();


        // Each spot and queue size
        tabHotFoodSpot = new Spot[1];
        tabHotFoodSpot[0] = new Spot(0);

        tabSandSpot = new Spot[1];
        tabSandSpot[0] = new Spot(0);

        tabDrinkSpot = new Spot[1];
        tabDrinkSpot[0] = new Spot(0);

        tabCashierSpot = new Spot[2];
        tabCashierSpot[0] = new Spot(0);
        tabCashierSpot[1] = new Spot(1);

        int morePersons = 0;
        int actualState = 0;

        //Simulation
        for(int i = 0; i < howManyIterations; i++) {

            // Should I generate more persons?
            if (morePersons == 1) {

                //State of the next group of persons?
                double inicialState = rn.nextDouble() % 1;

                //How Many?
                double howManyPersons = rn.nextDouble() % 1;

                if (inicialState >= 0.2) {
                    actualState = 0;
                } else if (inicialState >= 0.05 && inicialState < 0.2){
                    actualState = 1;
                } else{
                    actualState = 2;
                }

                if (howManyPersons >= 0.5) {
                    if(actualState == 0) {
                        tabHotFoodSpot[0].addPersonToQueue();
                    } else if(actualState == 1) {
                        tabSandSpot[0].addPersonToQueue();
                    } else if(actualState == 2) {
                        tabDrinkSpot[0].addPersonToQueue();
                    }
                } else if (howManyPersons >= 0.2 && howManyPersons < 0.5) {
                    if(actualState == 0) {
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                    } else if(actualState == 1) {
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                    } else if(actualState == 2) {
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                    }
                } else if (howManyPersons >= 0.1 && howManyPersons < 0.2) {
                    if(actualState == 0) {
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                    } else if(actualState == 1) {
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                    } else if(actualState == 2) {
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                    }
                } else {
                    if(actualState == 0) {
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                        tabHotFoodSpot[0].addPersonToQueue();
                    } else if(actualState == 1) {
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                        tabSandSpot[0].addPersonToQueue();
                    } else if(actualState == 2) {
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                        tabDrinkSpot[0].addPersonToQueue();
                    }
                }
            }

            if(!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabHotFoodSpot[0].run();
            }

            if(!tabSandSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabSandSpot[0].run();
            }

            if(!tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabDrinkSpot[0].run();
            }

            if(!tabCashierSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabCashierSpot[0].run();
            }

            if(!tabCashierSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabCashierSpot[1].run();
            }



        }

        System.out.println("Finish . . .");
    }
}
