package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

interface RandomStream {
    abstract public double next();
}

class Uniform01 implements RandomStream {
    final private Random rnd;
    public Uniform01(int stream) {rnd = new Random(stream);}
    @Override
    public double next() {return rnd.nextDouble();}
}


class Exponential extends Uniform01 {
    final private double mean;
    public Exponential(int stream, double mean) {
        super(stream);

        this.mean = mean;
    }
    @Override
    public double next() {return -mean * Math.log(super.next());}
}






public class Main {


    public static int compareQueues(Spot tab[], int size) {
        int index = 0;
        for(int i = 1; i < size; i++) {
            if (tab[i].getSpotQueueOfPersons().size() > tab[i - 1].getSpotQueueOfPersons().size())
                index = i;
        }
        return(index);
    }

    public static void main(String[] args) throws FileNotFoundException {



        //ver site:  https://www.npmjs.com/package/exponential-smoothing-stream///

        Exponential exponential = new Exponential(13,30);
        for(int i = 0 ; i < 100 ;i++){
          ///  Random randomDouble = new Random();
           /// double U =  randomDouble.nextDouble() % 1;
           // double x = Math.log(1-U)/(-30);
            //System.out.println(" X:  " + x);
            System.out.println(" EXPO " + exponential.next());
        }

    /*    Spot tabHotFoodSpot[];
        Spot tabSandSpot[];
        Spot tabDrinkSpot[];
        Spot tabCashierSpot[];
        ArrayList <Person> tabOfPersons[];
        int value;



        Person actualPerson;


        //simulation total time
        int howManyIterations = 5400;
        Random rn = new Random();
        Random randomDouble = new Random();


        // Each spot and queue size
        tabHotFoodSpot = new Spot[1];
        tabHotFoodSpot[0] = new Spot(0);

        tabSandSpot = new Spot[1];
        tabSandSpot[0] = new Spot(1);

        tabDrinkSpot = new Spot[1];
        tabDrinkSpot[0] = new Spot(2);

        tabCashierSpot = new Spot[2];
        tabCashierSpot[0] = new Spot(3);
        tabCashierSpot[1] = new Spot(3);

        int morePersons = 0;
        int actualState = 0;
        int biggerQueue;

        int hotFoodNum = tabHotFoodSpot.length;
        int sandSpotNum = tabSandSpot.length;
        int drinkSpotNum = tabDrinkSpot.length;
        int cashierSpotNum = tabCashierSpot.length;


        //Simulation
        for(int i = 0; i < howManyIterations; i++) {


            double U =  randomDouble.nextDouble() % 1;
            double x = Math.log(1-U)/30;
            // Should I generate more persons?
            if (morePersons == 1) {

                //State of the next group of persons?
                double inicialState;

                //How Many?
                double howManyPersons = rn.nextDouble() % 1;

                if (howManyPersons >= 0.5) {
                    value = 1;
                }
                else if (howManyPersons >= 0.2 && howManyPersons < 0.5) {
                    value = 2;
                }
                else if (howManyPersons >= 0.1 && howManyPersons < 0.2) {
                    value = 3;
                }else {
                    value = 4;
                }

                for(int j = 0; j < value; j++) {
                    inicialState = rn.nextDouble() % 1;

                    if (inicialState >= 0.2) {
                        actualState = 0;
                    } else if (inicialState >= 0.05 && inicialState < 0.2){
                        actualState = 1;
                    } else{
                        actualState = 2;
                    }

                    if(actualState == 0) {
                        Person newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        biggerQueue = compareQueues(tabHotFoodSpot,hotFoodNum);
                        tabHotFoodSpot[biggerQueue].addPersonToQueue(newPerson);
                    } else if(actualState == 1) {
                        Person newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        biggerQueue = compareQueues(tabSandSpot,sandSpotNum);
                        tabSandSpot[biggerQueue].addPersonToQueue(newPerson);
                    } else if(actualState == 2) {
                        Person newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        biggerQueue = compareQueues(tabDrinkSpot,drinkSpotNum);
                        tabDrinkSpot[biggerQueue].addPersonToQueue(newPerson);
                    }
                }

            }

            if(!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty()){
                actualPerson = tabHotFoodSpot[0].run();
                if(actualPerson != null){
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                    tabSandSpot[0].addPersonToQueue(actualPerson);
                }
            }

            if(!tabSandSpot[0].getSpotQueueOfPersons().isEmpty()){
                actualPerson = tabSandSpot[0].run();
                if(actualPerson != null){
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                    tabDrinkSpot[0].addPersonToQueue(actualPerson);
                }
            }

            if(!tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty()){
                actualPerson = tabDrinkSpot[0].run();
                if(actualPerson != null){
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                    tabCashierSpot[0].addPersonToQueue(actualPerson);
                }
            }

            if(!tabCashierSpot[0].getSpotQueueOfPersons().isEmpty()){
                tabCashierSpot[0].run();
            }

            if(!tabCashierSpot[1].getSpotQueueOfPersons().isEmpty()){
                tabCashierSpot[1].run();
            }

        }


        System.out.println("Finish . . .");

      */  }
    }

