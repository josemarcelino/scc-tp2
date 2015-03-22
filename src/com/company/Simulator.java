package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by josemarcelino on 3/22/15.
 */
public class Simulator {
    Spot tabHotFoodSpot[];
    Spot tabSandSpot[];
    Spot tabDrinkSpot[];
    Spot tabCashierSpot[];
    Statistics stats;
    ArrayList<Person> tabOfPersons;
    int value;
    Person actualPerson;
    int count = 0 ;

    public int compareQueues(Spot tab[], int size) {
        int index = 0;
        for(int i = 1; i < size; i++) {
            if (tab[i].getSpotQueueOfPersons().size() > tab[i - 1].getSpotQueueOfPersons().size())
                index = i;
        }
        return(index);
    }

    void run() {
        //simulation total time
        stats = new Statistics();
        tabOfPersons = new ArrayList<Person>();
        int howManyIterations = 5400;
        Random rn = new Random();

        Person newPerson;

        // Each spot and queue size
        tabHotFoodSpot = new Spot[1];
        tabHotFoodSpot[0] = new Spot(3);

        tabSandSpot = new Spot[1];
        tabSandSpot[0] = new Spot(2);

        tabDrinkSpot = new Spot[1];
        tabDrinkSpot[0] = new Spot(1);

        tabCashierSpot = new Spot[2];
        tabCashierSpot[0] = new Spot(0);
        tabCashierSpot[1] = new Spot(0);

        int morePersons = 1;
        int actualState;
        int biggerQueue;
        int index;
        double howManyPersonInTheSystem;

        int hotFoodNum = tabHotFoodSpot.length;
        int sandSpotNum = tabSandSpot.length;
        int drinkSpotNum = tabDrinkSpot.length;
        int cashierSpotNum = tabCashierSpot.length;

        Exponential exponential = new Exponential((int)new Date().getTime(),30);
        count = (int)exponential.next();



        //Simulation
        for (int i = 0; i < howManyIterations; i++) {

            double U = rn.nextDouble() % 1;
            double x = Math.log(1 - U) / 30;


            // Should I generate more persons?
            if (morePersons == 1) {

                //State of the next group of persons?
                double inicialState;

                //How Many?
                double howManyPersons = rn.nextDouble() % 1;

                if (howManyPersons >= 0.5) {
                    value = 1;
                } else if (howManyPersons >= 0.2 && howManyPersons < 0.5) {
                    value = 2;
                } else if (howManyPersons >= 0.1 && howManyPersons < 0.2) {
                    value = 3;
                } else {
                    value = 4;
                }

                for (int j = 0; j < value; j++) {
                    inicialState = rn.nextDouble() % 1;

                    if (inicialState >= 0.2) {
                        actualState = 3;
                    } else if (inicialState >= 0.05 && inicialState < 0.2) {
                        actualState = 2;
                    } else {
                        actualState = 1;
                    }
                    if (actualState == 3) {
                        newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        newPerson.setFirstSpot(actualState);
                        biggerQueue = compareQueues(tabHotFoodSpot, hotFoodNum);
                        tabHotFoodSpot[biggerQueue].addPersonToQueue(newPerson);
                        tabOfPersons.add(newPerson);

                    } else if (actualState == 2) {
                        newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        newPerson.setFirstSpot(actualState);
                        biggerQueue = compareQueues(tabSandSpot, sandSpotNum);
                        tabSandSpot[biggerQueue].addPersonToQueue(newPerson);
                        tabOfPersons.add(newPerson);

                    } else if (actualState == 1) {
                        newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        newPerson.setFirstSpot(actualState);
                        biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                        tabDrinkSpot[biggerQueue].addPersonToQueue(newPerson);
                        tabOfPersons.add(newPerson);

                    }
                }

            }

                actualPerson = tabHotFoodSpot[0].run();
                if (actualPerson != null) {
                    index = tabOfPersons.indexOf(actualPerson);
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 2);
                    tabOfPersons.set(index, actualPerson);
                    biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                    tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                }

                actualPerson = tabSandSpot[0].run();
                if (actualPerson != null) {
                    index = tabOfPersons.indexOf(actualPerson);
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                    tabOfPersons.set(index, actualPerson);
                    biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                    tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                }

                actualPerson = tabDrinkSpot[0].run();
                if (actualPerson != null) {
                    index = tabOfPersons.indexOf(actualPerson);
                    actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                    tabOfPersons.set(index, actualPerson);
                    biggerQueue = compareQueues(tabCashierSpot, cashierSpotNum);
                    tabCashierSpot[biggerQueue].addPersonToQueue(actualPerson);
                }

                actualPerson = tabCashierSpot[0].run();
                if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);
                 }

               actualPerson = tabCashierSpot[1].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);
            }


            morePersons = 0;

            if(count == 0 && howManyIterations%30 == 0){
                morePersons = 1;
                count = (int)exponential.next();
            }


            howManyPersonInTheSystem = 0;
            for(Person n : tabOfPersons){
                if(n.getActualSpot() >= 0){
                    howManyPersonInTheSystem++;
                }


                System.out.println("Pessoa Numero " + tabOfPersons.indexOf(n));
                System.out.println("Esta no Spot " + n.getActualSpot());
                System.out.println("Desde que Entrou " + n.getTotalTime());
                System.out.println();
            }
            //List<Double> aux = stats.getPeopleInTheSystem();
            //aux.add(howManyPersonInTheSystem);
            //stats.setPeopleInTheSystem(aux);
            stats.addValue(howManyPersonInTheSystem);
            count--;



        }




        System.out.println("Finish . . .");
    }
}

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
