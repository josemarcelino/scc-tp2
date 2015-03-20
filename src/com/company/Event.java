package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
abstract class Event implements Comparable<Event> {
    protected double time = 0;
    public Event() {}
    public void time(double time) {
        assert (time >= 0): "Event.time: Time error.";
        this. time = time;
    }
    public double time() {return time;}
    public abstract void execute();
    @Override
    public int compareTo(Event e) {
        if (time > e.time) return 1;
        return -1;
    }
    @Override
    public String toString() {return this.getClass().getSimpleName() + " " + String.format("%.2f", time);}
}
