package com.company;

/**
 * Created by josemarcelino on 3/21/15.
 */
public class Person extends Token{

    // Time this person will waste at the cachier
    double accumulationTime;
    // Time this person will waste on this Spot
    double idleTime;
    //Actual Spot
    int actualSpot;
    //Total Time since arrival
    double totalTime;

    public double getTotalTime() {
        return totalTime;
    }

    public int getActualSpot() {
        return actualSpot;
    }

    public double getAccumulationTime() {
        return accumulationTime;
    }

    public double getIdleTime() {
        return idleTime;
    }

    public void setAccumulationTime(double accumulationTime) {
        this.accumulationTime = accumulationTime;
    }

    public void setIdleTime(double idleTime) {
        this.idleTime = idleTime;
    }

    public void setActualSpot(int actualSpot) {
        this.actualSpot = actualSpot;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
}
