package com.company;

import java.util.Random;

/**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
public class Uniform01 implements RandomStream {
    final private Random rnd;
    public Uniform01(int stream) {rnd = new Random(stream);}
    @Override
    public double next() {return rnd.nextDouble();}
}
