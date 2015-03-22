package com.company;


import java.util.ArrayList;
import java.util.List;

public class Statistics {

    List<Double> peopleInTheSystem;

    List<Double> peopleAtHotFood;
    List<Double> peopleAtSand;
    List<Double> peopleAtDrink;
    List<Double> peopleAtCachier;

    List<Double> timeWastedInTheSystem;
    List<Double> timeWastedAtHotFood;
    List<Double> timeWastedAtSand;
    List<Double> timeWastedAtDrink;
    List<Double> timeWastedAtCachier;

    List<Double> type3timeWastedAtHotFood;
    List<Double> type3timeWastedAtDrink;
    List<Double> type3timeWastedAtCachier;

    List<Double> type2timeWastedAtSand;
    List<Double> type2timeWastedAtDrink;
    List<Double> type2timeWastedAtCachier;

    List<Double> type1timeWastedAtDrink;
    List<Double> type1timeWastedAtCachier;


    public Statistics() {
        this.peopleInTheSystem = new ArrayList<Double>();
        this.peopleAtHotFood = new ArrayList<Double>();
        this.peopleAtSand = new ArrayList<Double>();
        this.peopleAtDrink = new ArrayList<Double>();
        this.peopleAtCachier = new ArrayList<Double>();
        this.timeWastedInTheSystem = new ArrayList<Double>();
        this.timeWastedAtHotFood = new ArrayList<Double>();
        this.timeWastedAtSand = new ArrayList<Double>();
        this.timeWastedAtDrink = new ArrayList<Double>();
        this.timeWastedAtCachier = new ArrayList<Double>();
        this.type3timeWastedAtHotFood = new ArrayList<Double>();
        this.type3timeWastedAtDrink = new ArrayList<Double>();
        this.type3timeWastedAtCachier = new ArrayList<Double>();
        this.type2timeWastedAtSand = new ArrayList<Double>();
        this.type2timeWastedAtDrink = new ArrayList<Double>();
        this.type2timeWastedAtCachier = new ArrayList<Double>();
        this.type1timeWastedAtDrink = new ArrayList<Double>();
        this.type1timeWastedAtCachier = new ArrayList<Double>();
    }



    public void setPeopleAtCachier(List<Double> peopleAtCachier) {
        this.peopleAtCachier = peopleAtCachier;
    }

    public void setPeopleAtDrink(List<Double> peopleAtDrink) {
        this.peopleAtDrink = peopleAtDrink;
    }

    public void setPeopleAtHotFood(List<Double> peopleAtHotFood) {
        this.peopleAtHotFood = peopleAtHotFood;
    }

    public void setPeopleAtSand(List<Double> peopleAtSand) {
        this.peopleAtSand = peopleAtSand;
    }

    public void setPeopleInTheSystem(List<Double> peopleInTheSystem) {
        this.peopleInTheSystem = peopleInTheSystem;
    }

    public void setTimeWastedAtCachier(List<Double> timeWastedAtCachier) {
        this.timeWastedAtCachier = timeWastedAtCachier;
    }

    public void setTimeWastedAtDrink(List<Double> timeWastedAtDrink) {
        this.timeWastedAtDrink = timeWastedAtDrink;
    }

    public void setTimeWastedAtHotFood(List<Double> timeWastedAtHotFood) {
        this.timeWastedAtHotFood = timeWastedAtHotFood;
    }

    public void setTimeWastedAtSand(List<Double> timeWastedAtSand) {
        this.timeWastedAtSand = timeWastedAtSand;
    }

    public void setTimeWastedInTheSystem(List<Double> timeWastedInTheSystem) {
        this.timeWastedInTheSystem = timeWastedInTheSystem;
    }

    public void setType1timeWastedAtCachier(List<Double> type1timeWastedAtCachier) {
        this.type1timeWastedAtCachier = type1timeWastedAtCachier;
    }

    public void setType1timeWastedAtDrink(List<Double> type1timeWastedAtDrink) {
        this.type1timeWastedAtDrink = type1timeWastedAtDrink;
    }

    public void setType2timeWastedAtCachier(List<Double> type2timeWastedAtCachier) {
        this.type2timeWastedAtCachier = type2timeWastedAtCachier;
    }

    public void setType2timeWastedAtDrink(List<Double> type2timeWastedAtDrink) {
        this.type2timeWastedAtDrink = type2timeWastedAtDrink;
    }

    public void setType2timeWastedAtSand(List<Double> type2timeWastedAtSand) {
        this.type2timeWastedAtSand = type2timeWastedAtSand;
    }

    public void setType3timeWastedAtCachier(List<Double> type3timeWastedAtCachier) {
        this.type3timeWastedAtCachier = type3timeWastedAtCachier;
    }

    public void setType3timeWastedAtDrink(List<Double> type3timeWastedAtDrink) {
        this.type3timeWastedAtDrink = type3timeWastedAtDrink;
    }

    public void setType3timeWastedAtHotFood(List<Double> type3timeWastedAtHotFood) {
        this.type3timeWastedAtHotFood = type3timeWastedAtHotFood;
    }

    public void addValueToNewPeopleInTheSystemList(Double newPeopleInTheSystem){
        peopleInTheSystem.add(newPeopleInTheSystem);
    }

    public List<Double> getPeopleInTheSystem() {
        return peopleInTheSystem;
    }

    public List<Double> getPeopleAtCachier() {
        return peopleAtCachier;
    }

    public List<Double> getPeopleAtDrink() {
        return peopleAtDrink;
    }

    public List<Double> getPeopleAtHotFood() {
        return peopleAtHotFood;
    }

    public List<Double> getPeopleAtSand() {
        return peopleAtSand;
    }

    public List<Double> getTimeWastedAtCachier() {
        return timeWastedAtCachier;
    }

    public List<Double> getTimeWastedAtDrink() {
        return timeWastedAtDrink;
    }

    public List<Double> getTimeWastedAtHotFood() {
        return timeWastedAtHotFood;
    }

    public List<Double> getTimeWastedAtSand() {
        return timeWastedAtSand;
    }

    public List<Double> getTimeWastedInTheSystem() {
        return timeWastedInTheSystem;
    }

    public List<Double> getType1timeWastedAtCachier() {
        return type1timeWastedAtCachier;
    }

    public List<Double> getType1timeWastedAtDrink() {
        return type1timeWastedAtDrink;
    }

    public List<Double> getType2timeWastedAtCachier() {
        return type2timeWastedAtCachier;
    }

    public List<Double> getType2timeWastedAtDrink() {
        return type2timeWastedAtDrink;
    }

    public List<Double> getType2timeWastedAtSand() {
        return type2timeWastedAtSand;
    }

    public List<Double> getType3timeWastedAtCachier() {
        return type3timeWastedAtCachier;
    }

    public List<Double> getType3timeWastedAtDrink() {
        return type3timeWastedAtDrink;
    }

    public List<Double> getType3timeWastedAtHotFood() {
        return type3timeWastedAtHotFood;
    }
}


