package com.company;

/**
 * Created by pedro on 18-03-2015.
 */
public class Exponential extends Uniform01 {
    final private double mean;
    public Exponential(int stream, double mean) {
        super(stream);
        this.mean = mean;
    }
    @Override
    public double next() {return -mean * Math.log(super.next());}
}
