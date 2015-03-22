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

    double maxPeopleInTheSystem;
    double maxPeopleInHot;
    double maxPeopleInSand;
    double maxPeopleInDrinks;
    double maxPeopleInCashier;
    double maxDelayHot;
    double maxDelaySand;
    double maxDelayCashier;
    double maxDelayDrink;

    ArrayList<Person> tabOfPersons;
    int value;
    Person actualPerson;
    int count = 0;

    public int compareQueues(Spot tab[], int size) {
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (tab[i].getSpotQueueOfPersons().size() > tab[i - 1].getSpotQueueOfPersons().size())
                index = i;
        }
        return (index);
    }

    void run() {
        //simulation total time
        maxPeopleInTheSystem = 0;
        maxPeopleInCashier = 0;
        maxPeopleInDrinks = 0;
        maxPeopleInHot = 0;
        maxPeopleInSand = 0;

        maxDelayHot = 0;
        maxDelayCashier = 0;
        maxDelayDrink = 0;
        maxDelaySand = 0;

        stats = new Statistics();
        tabOfPersons = new ArrayList<Person>();
        int howManyIterations = 5400;
        Random rn = new Random();

        Person newPerson;

        // Each spot and queue size
        tabHotFoodSpot = new Spot[1];  //mudar nas seguintes alineas
        tabHotFoodSpot[0] = new Spot(3);
        //b-> i / ii
        //tabHotFoodSpot[1] = new Spot(3);

        tabSandSpot = new Spot[1]; //mudar nas seguintes alineas
        tabSandSpot[0] = new Spot(2);
        //b) i   / iii
        //tabSandSpot[1] = new Spot(2);

        tabDrinkSpot = new Spot[1];
        tabDrinkSpot[0] = new Spot(1);


        tabCashierSpot = new Spot[2];
        tabCashierSpot[0] = new Spot(0);
        tabCashierSpot[1] = new Spot(0);
        //tabCashierSpot[2] = new Spot(0);

        int morePersons = 1;
        int actualState;
        int biggerQueue;
        int index;
        double howManyPersonInTheSystem;
        double howManyPersonInHot;
        double howManyPersonInSand;
        double howManyPersonInDrinks;
        double howManyPersonInCashier;

        int hotFoodNum = tabHotFoodSpot.length;
        int sandSpotNum = tabSandSpot.length;
        int drinkSpotNum = tabDrinkSpot.length;
        int cashierSpotNum = tabCashierSpot.length;

        Exponential exponential = new Exponential((int) new Date().getTime(), 30);
        count = (int) exponential.next();


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
                        stats.getTimeWastedAtHotFood().add(newPerson.getIdleTime());

                    } else if (actualState == 2) {
                        newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        newPerson.setFirstSpot(actualState);
                        biggerQueue = compareQueues(tabSandSpot, sandSpotNum);
                        tabSandSpot[biggerQueue].addPersonToQueue(newPerson);
                        tabOfPersons.add(newPerson);
                        stats.getTimeWastedAtSand().add(newPerson.getIdleTime());

                    } else if (actualState == 1) {
                        newPerson = new Person();
                        newPerson.setActualSpot(actualState);
                        newPerson.setFirstSpot(actualState);
                        biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                        tabDrinkSpot[biggerQueue].addPersonToQueue(newPerson);
                        tabOfPersons.add(newPerson);
                        stats.getTimeWastedAtDrink().add(newPerson.idleTime);

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
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            }

            //no caso de duas hot food  b-> i / ii  / c
            /*actualPerson = tabHotFoodSpot[1].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 2);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            } */

            actualPerson = tabSandSpot[0].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            }

            //No caso de duas sandes b->i / iii / c
            /*actualPerson = tabSandSpot[1].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            }*/

            actualPerson = tabDrinkSpot[0].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabCashierSpot, cashierSpotNum);
                tabCashierSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getPeopleAtCachier().add(actualPerson.getIdleTime());
            }

            actualPerson = tabCashierSpot[0].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            }

            actualPerson = tabCashierSpot[1].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            }

            //TERCEIRO CASHIER /////
            /*
            actualPerson = tabCashierSpot[1].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            } */


            morePersons = 0;

            if (count <= 0) {
                morePersons = 1;
                count = (int) exponential.next();
            }


            howManyPersonInTheSystem = 0;
            howManyPersonInCashier = 0;
            howManyPersonInDrinks = 0;
            howManyPersonInHot = 0;
            howManyPersonInSand = 0;
            for (Person n : tabOfPersons) {
                if (n.getActualSpot() >= 0) {
                    howManyPersonInTheSystem++;
                }
                if (n.getActualSpot() == 3) {
                    howManyPersonInHot++;
                    if (n.getIdleTime() > maxDelayHot) {
                        maxDelayHot = n.getIdleTime();
                    }
                } else if (n.getActualSpot() == 2) {
                    howManyPersonInSand++;
                    if (n.getIdleTime() > maxDelaySand)
                        maxDelaySand = n.getIdleTime();
                } else if (n.getActualSpot() == 1) {
                    howManyPersonInDrinks++;
                    if (n.getIdleTime() > maxDelayDrink)
                        maxDelayDrink = n.getIdleTime();
                } else if (n.getActualSpot() == 0) {
                    howManyPersonInCashier++;
                    if (n.getIdleTime() > maxDelayCashier)
                        maxDelayCashier = n.getIdleTime();
                }


                System.out.println("Pessoa Numero " + tabOfPersons.indexOf(n));
                System.out.println("Esta no Spot " + n.getActualSpot());
                System.out.println("Desde que Entrou " + n.getTotalTime());
                System.out.println();
            }
            //List<Double> aux = stats.getPeopleInTheSystem();
            //aux.add(howManyPersonInTheSystem);
            //stats.setPeopleInTheSystem(aux);
            if (howManyPersonInTheSystem > maxPeopleInTheSystem)
                maxPeopleInTheSystem = howManyPersonInTheSystem;
            if (howManyPersonInHot > maxPeopleInHot)
                maxPeopleInHot = howManyPersonInHot;
            if (howManyPersonInSand > maxPeopleInSand)
                maxPeopleInSand = howManyPersonInSand;
            if (howManyPersonInDrinks > maxPeopleInDrinks)
                maxPeopleInDrinks = howManyPersonInDrinks;
            if (howManyPersonInCashier > maxPeopleInCashier)
                maxPeopleInCashier = howManyPersonInCashier;
            System.out.println("Estão neste momento estas pessoas no sistema: " + howManyPersonInTheSystem);
            System.out.println("Estão neste momento estas pessoas no sistema: " + howManyPersonInTheSystem);
            System.out.println("Estão neste momento estas pessoas nos Hot Food: " + howManyPersonInHot);
            System.out.println("Estão neste momento estas pessoas nas Sandwi: " + howManyPersonInSand);
            System.out.println("Estão neste momento estas pessoas nas Bebidas: " + howManyPersonInDrinks);
            System.out.println("Estão neste momento estas pessoas para pagar: " + howManyPersonInCashier);
            stats.addValueToNewPeopleInTheSystemList(howManyPersonInTheSystem);
            stats.addValueToPeopleInCashier(howManyPersonInCashier);
            stats.addValueToPeopleInDrink(howManyPersonInDrinks);
            stats.addValueToPeopleInHot(howManyPersonInHot);
            stats.addValueToPeopleInSand(howManyPersonInSand);

            count--;
            //System.out.println("COUNT ::: " + count);


        }

        //Acabar os restantes clientes
        //a->i
        //while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || !tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[2].getSpotQueueOfPersons().isEmpty())
        //b-> i
       // while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabHotFoodSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[1].getSpotQueueOfPersons().isEmpty()||tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty())
        //b -> ii
        //while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabHotFoodSpot[1].getSpotQueueOfPersons().isEmpty()|| !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || !tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[2].getSpotQueueOfPersons().isEmpty())
        //b -> iii
        // while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || tabSandSpot[1].getSpotQueueOfPersons().isEmpty()|| !tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[2].getSpotQueueOfPersons().isEmpty())
        //c)
      //  while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabHotFoodSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[1].getSpotQueueOfPersons().isEmpty() || !tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[2].getSpotQueueOfPersons().isEmpty())
        while (!tabHotFoodSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[0].getSpotQueueOfPersons().isEmpty() || !tabSandSpot[0].getSpotQueueOfPersons().isEmpty() || !tabDrinkSpot[0].getSpotQueueOfPersons().isEmpty() || !tabCashierSpot[1].getSpotQueueOfPersons().isEmpty()) {
            actualPerson = tabHotFoodSpot[0].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 2);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            }
            //segundo hotfood b->i / ii

           /* actualPerson = tabHotFoodSpot[1].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 2);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            } */

            actualPerson = tabSandSpot[0].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            }
            //segundo sand. b-> i / iii

           /* actualPerson = tabSandSpot[1].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabDrinkSpot, drinkSpotNum);
                tabDrinkSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getTimeWastedAtDrink().add(actualPerson.getIdleTime());
            } */

            actualPerson = tabDrinkSpot[0].run();
            if (actualPerson != null) {
                index = tabOfPersons.indexOf(actualPerson);
                actualPerson.setActualSpot(actualPerson.getActualSpot() - 1);
                tabOfPersons.set(index, actualPerson);
                biggerQueue = compareQueues(tabCashierSpot, cashierSpotNum);
                tabCashierSpot[biggerQueue].addPersonToQueue(actualPerson);
                stats.getPeopleAtCachier().add(actualPerson.getIdleTime());
            }

            actualPerson = tabCashierSpot[0].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            }

            actualPerson = tabCashierSpot[1].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            }

            ///////////TERCEIRO CASHIER //////
            /*actualPerson = tabCashierSpot[2].run();
            if (actualPerson != null) {
                tabOfPersons.get(tabOfPersons.indexOf(actualPerson)).setActualSpot(-1);

            } */

            howManyPersonInTheSystem = 0;
            howManyPersonInCashier = 0;
            howManyPersonInDrinks = 0;
            howManyPersonInHot = 0;
            howManyPersonInSand = 0;


            for (Person n : tabOfPersons) {
                if (n.getActualSpot() >= 0) {
                    howManyPersonInTheSystem++;
                }
                if (n.getActualSpot() == 3) {
                    howManyPersonInHot++;
                    if (n.getIdleTime() > maxDelayHot) {
                        maxDelayHot = n.getIdleTime();
                    }
                } else if (n.getActualSpot() == 2) {
                    howManyPersonInSand++;
                    if (n.getIdleTime() > maxDelaySand)
                        maxDelaySand = n.getIdleTime();
                } else if (n.getActualSpot() == 1) {
                    howManyPersonInDrinks++;
                    if (n.getIdleTime() > maxDelayDrink)
                        maxDelayDrink = n.getIdleTime();
                } else if (n.getActualSpot() == 0) {
                    howManyPersonInCashier++;
                    if (n.getIdleTime() > maxDelayCashier)
                        maxDelayCashier = n.getIdleTime();
                }
            }


                System.out.println("Estão neste momento estas pessoas no sistema: " + howManyPersonInTheSystem);
                System.out.println("Estão neste momento estas pessoas nos Hot Food: " + howManyPersonInHot);
                System.out.println("Estão neste momento estas pessoas nas Sandwi: " + howManyPersonInSand);
                System.out.println("Estão neste momento estas pessoas nas Bebidas: " + howManyPersonInDrinks);
                System.out.println("Estão neste momento estas pessoas para pagar: " + howManyPersonInCashier);
                stats.addValueToNewPeopleInTheSystemList(howManyPersonInTheSystem);
                stats.addValueToPeopleInCashier(howManyPersonInCashier);
                stats.addValueToPeopleInDrink(howManyPersonInDrinks);
                stats.addValueToPeopleInHot(howManyPersonInHot);
                stats.addValueToPeopleInSand(howManyPersonInSand);


            }


            System.out.println("Max people in the system :     " + maxPeopleInTheSystem);
            System.out.println("Average Delay in system:       " + stats.averageTotalWait());
            System.out.println("Average People in system:      " + (int)stats.averageTotalPeople());
            System.out.println("Max people in hot:             " + maxPeopleInHot);
            System.out.println("Average people in hot:         " + (int)stats.averagePeopleHot());
            System.out.println("Max Delay in  hot:             " + maxDelayHot);
            System.out.println("Average in hot:                " + stats.averageHot()) ;
            System.out.println("Max people in sand:            " + maxPeopleInSand);
            System.out.println(" Average people in sand        " + (int)stats.averagePeopleSand());
            System.out.println("Max Delay in  sand:            " + maxDelaySand);
            System.out.println("Average in sand:               " + stats.averageSand()) ;
            System.out.println("Max people in drinks:          " + maxPeopleInDrinks);
            System.out.println("Average people in drinks:      " + (int)stats.averagePeopleDrinks());
            System.out.println("Max Delay in  drinks:          " + maxDelayDrink);
            System.out.println("Average in Drinks:             " + stats.averageDrinks()) ;
            System.out.println("Max people in Cashier:         " + maxPeopleInCashier);
            System.out.println("Average people in Cashier      " + (int)stats.averagePeopleCachier());
            System.out.println("Max Delay in  Cashier:         " + maxDelayCashier);
            System.out.println("Average in Cashier:            " + stats.averageCachier()) ;

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

