package com.company;

/**
 * Created by pedro on 18-03-2015.
 */
public class Accumulate {
    private int value = 0;
    private double accum = 0.0;
    private double last = 0.0;
    public Accumulate(int value) {this.value = value;}
    public void inc(int d, double time) {set(value + d, time);}
    public void set(int v, double time) {
        double delta = time - last;
        accum += value * delta;
        this.value = v;
        last = time;
    }
    public double mean(double time) {return integral(time) / time;}
    public double integral(double time) {
        double delta = time - last;
        accum += value * delta;
        last = time;
        return accum;
    }
    public int value() {return value;}
    @Override
    public String toString() {return "" + value + " " + accum + " " + last;}
}
