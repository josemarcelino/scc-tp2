package com.company;

/**
 * Created by pedro on 18-03-2015.
 */
public class Sequence implements RandomStream {
    final private double[] values;
    private int curr;
    public Sequence(double[] values) {
        this.values = values;
        curr = 0;
    }
    @Override
    public double next() {
        return values[curr++];
    }
}
