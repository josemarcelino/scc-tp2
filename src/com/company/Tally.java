package com.company;

import java.util.*;

/**
 * Created by pedro on 18-03-2015.
 */
public class Tally {
    final private List<Double> values;
    public Tally() {values = new ArrayList<Double>();}
    public double mean() {
        double sum = 0.0;
        for (Double value: values) sum += value;
        return sum / values.size();
    }
    public double stdDev() {
        double sum = 0.0;
        double mean = mean();
        for (Double value: values) sum +=  Math.pow(mean - value, 2);
        return Math.sqrt(sum / (values.size() - 1));
    }
    public void add(double value) {values.add(value);}
    public void clear() {values.clear();}
    @Override
    public String toString() {return "" + values;}
}
