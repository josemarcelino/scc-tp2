package com.company;

/**
 * Created by pedro on 18-03-2015.
 */
public class Uniform extends Uniform01 {
    final private double a, b;
    public Uniform(int stream, double a, double b) {
        super(stream);
        assert (a < b);
        this.a = a;
        this.b = b;
    }
    @Override
    public double next() {return a + super.next() * (b - a);}
}
