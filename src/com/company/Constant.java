package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
public class Constant implements RandomStream {
    final private double value;
    public Constant(int value) {this.value = value;}
    @Override
    public double next() {return value;}
}
