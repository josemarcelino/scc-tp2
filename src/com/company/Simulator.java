package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
final class Simulator {
    private final Model model;
    double clock;
    private final EventList events;
    public Simulator(Model model) {
        this.model = model;
        clock = 0.0;
        events = new EventList();
    }
    protected void cancel(Event e) {events.cancel(e);}
    public Event schedule(Event e, double delta) {
        assert (delta >= 0): "Simulator.schedule, time error! " + delta;
        events.schedule(e, clock + delta);
        return e;
    }
    public boolean reschedule(Event e, double delta) {
        assert (delta >= 0): "Simulation.reschedule, time error! " + delta;
        return events.reschedule(e, clock + delta);
    }
    public void clear() {events.clear();}
    public final void run() {
        model.init();
        while (! events.empty()) {
            Event event = events.pop();
            double curr = event.time();
            assert (curr >= clock): "Simulation.run, time error. " + curr + " > " + clock;
            clock = curr;
            event.execute();
        }
    }
}
