package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
abstract class Model {
    private Simulator simulator;
    protected void simulator(Simulator simulator) {this.simulator = simulator;}
    public Model() {}
    abstract protected void init();
    protected final void cancel(Event e) {simulator.cancel(e);}
    protected final Event schedule(Event ev, double delta) {
        assert (delta >= 0): "Model.schedule, time error! " + delta;
        simulator.schedule(ev, delta);
        return ev;
    }
    protected final boolean reschedule(Event e, double delta) {
        assert (delta >= 0): "Model.reschedule, time error! " + delta;
        return simulator.reschedule(e, delta);
    }
    protected final void clear() {simulator.clear();}
}

