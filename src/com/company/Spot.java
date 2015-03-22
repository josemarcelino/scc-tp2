package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by josemarcelino on 3/21/15.
 */
public class Spot extends Server {
    // actualSpotTyoe
    int actualSpot;

    Person actualPerson;

    //Max/Min each person wastes on this station
    double maximumDuringTime;
    double minimumDuringTime;

    //Max/Min each person adds to final waste at the cachier
    double maximumAccumulationTime;
    double minimumAccumulationTime;

    //Queue of persons at this station
    ArrayList <Person> SpotQueueOfPersons;

    public Spot(int actualSpot) {
        this.actualSpot = actualSpot;
        SpotQueueOfPersons = new ArrayList<Person>();
        //Hot Food spot
        if (actualSpot == 3) {
            this.maximumDuringTime = 120.0;
            this.minimumDuringTime = 50.0;
            this.maximumAccumulationTime = 20.0;
            this.minimumAccumulationTime = 40.0;
        }
        //Speciality Sandwiches spot
        else if (actualSpot == 2) {
            this.maximumDuringTime = 180.0;
            this.minimumDuringTime = 60.0;
            this.maximumAccumulationTime = 5.0;
            this.minimumAccumulationTime = 15.0;
        }
        //Drink spot
        else if (actualSpot == 1) {
            this.maximumDuringTime = 20.0;
            this.minimumDuringTime = 5.0;
            this.maximumAccumulationTime = 10.0;
            this.minimumAccumulationTime = 5.0;
        }
        //Cashier spot
        else {
            this.minimumAccumulationTime = 0.0;
            this.maximumAccumulationTime = 0.0;
            this.maximumDuringTime = 0.0;
            this.minimumDuringTime = 0.0;
        }
    }

    // Calculate how much time this client will waste
    int duringTime(){
        Random rn = new Random();
        double n = maximumDuringTime - minimumDuringTime + 1;
        double i = rn.nextDouble() % n;
        return ((int)(minimumDuringTime + i));
    }

    // Calculate how much should be add to this client
    int accumulationTime(){
        Random rn = new Random();
        double n = maximumAccumulationTime - minimumAccumulationTime + 1;
        double i = rn.nextDouble() % n;
        return (int)(minimumAccumulationTime + i);
    }

    Person run(){

        if(!SpotQueueOfPersons.isEmpty()){
            if(actualPerson == null){
                System.out.println("Um nova pessoa esta a ser atendida no spot " + actualSpot);
                actualPerson = SpotQueueOfPersons.get(0);
                double timeToAccumulate = actualPerson.getAccumulationTime();
                timeToAccumulate = timeToAccumulate + accumulationTime();
                actualPerson.setAccumulationTime(timeToAccumulate);
                double timeToStay = duringTime();
                if(actualSpot == 0){
                    timeToStay =actualPerson.getAccumulationTime();
                }
                actualPerson.setIdleTime(timeToStay);
            }

            double timeToWait = actualPerson.getIdleTime();
            actualPerson.setIdleTime(timeToWait - 1);
            System.out.println("No " + actualSpot + " faltam " + timeToWait + " segundos");
            System.out.println(actualPerson.getIdleTime());
            if(getActualPerson().getIdleTime() == 0 && actualSpot != 0){
                Person temp = actualPerson;
                SpotQueueOfPersons.remove(actualPerson);
                actualPerson = null;
                return temp;
            }
            else if(getActualPerson().getIdleTime() == 0 && actualSpot == 0) {
                SpotQueueOfPersons.remove(actualPerson);
                actualPerson = null;
            }

            for(Person aux :SpotQueueOfPersons){
                aux.setTotalTime(aux.getTotalTime() + 1);
            }
        }
        return null;
    }

    private void returnPersonToAnotherSpot(Person actualPerson, int i) {
    }

    public Person getActualPerson() {
        return actualPerson;
    }

    public int getActualSpot() {
        return actualSpot;
    }

    public double getMaximumAccumulationTime() {
        return maximumAccumulationTime;
    }

    public double getMaximumDuringTime() {
        return maximumDuringTime;
    }

    public double getMinimumAccumulationTime() {
        return minimumAccumulationTime;
    }

    public double getMinimumDuringTime() {
        return minimumDuringTime;
    }

    public ArrayList<Person> getSpotQueueOfPersons() {
        return SpotQueueOfPersons;
    }

    public void setMaximumAccumulationTime(double maximumAccumulationTime) {
        this.maximumAccumulationTime = maximumAccumulationTime;
    }

    public void setMaximumDuringTime(double maximumDuringTime) {
        this.maximumDuringTime = maximumDuringTime;
    }

    public void setMinimumAccumulationTime(double minimumAccumulationTime) {
        this.minimumAccumulationTime = minimumAccumulationTime;
    }

    public void setMinimumDuringTime(double minimumDuringTime) {
        this.minimumDuringTime = minimumDuringTime;
    }

    public void setSpotQueueOfPersons(ArrayList<Person> spotQueueOfPersons) {
        SpotQueueOfPersons = spotQueueOfPersons;
    }

    public void setActualSpot(int actualSpot) {
        this.actualSpot = actualSpot;
    }

    public void addPersonToQueue(Person actualPerson) {
        SpotQueueOfPersons.add(actualPerson);
    }

    public void setActualPerson(Person actualPerson) {
        actualPerson = actualPerson;
    }
}
