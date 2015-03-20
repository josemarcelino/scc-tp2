package com.company;

/**
 * Created by pedro on 18-03-2015.
 */

public class Discrete extends Uniform01 {
        private final double[] prob;
        private final double[] values;
        public Discrete(int stream, double[] values, double[] prob) {
            super(stream);
            double sum = 0.0;
            for (int i = 0; i < prob.length; ++i) sum += prob[i];
            assert(sum <= 1.0);
            this.prob = prob;
            this.values = values;
        }
        @Override
        public double next() {
            double rnd = super.next();
            int i = 0;
            double sum = prob[i];
            while (sum < rnd) sum += prob[++i];
            return values[i];
        }
    }

