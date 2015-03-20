package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
public class Average {
    private double sum;
    private int count;
    public Average() {clear();}
    public double mean() {return sum / count;}
    public void add(double value) {
        sum += value;
        ++count;
    }
    public int count() {return count;}
    public final void clear() {
        sum = 0.0;
        count = 0;
    }
    @Override
    public String toString() {return String.format("%.3f\t%d", mean(), count);}
}
