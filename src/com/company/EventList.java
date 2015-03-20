package com.company; /**
 * Created by pedro on 18-03-2015.
 */
import java.util.*;
final class EventList {
    protected final PriorityQueue<Event> eventList;
    public EventList() {
        this.eventList = new PriorityQueue<Event>(10);
    }
    public boolean empty() {return eventList.isEmpty();}
    public void clear() {eventList.clear();}
    public void schedule(Event e, double time) {
        e.time(time);
        eventList.add(e);
    }
    public boolean reschedule(Event e, double time) {
        boolean bool = eventList.remove(e);
        e.time(time);
        eventList.add(e);
        return bool;
    }
    public void cancel(Event e) {eventList.remove(e);}
    @Override
    public String toString() {return eventList.toString();}
    public double timeNext() {return eventList.peek().time();}
    public Event pop() {return eventList.poll();}
}
