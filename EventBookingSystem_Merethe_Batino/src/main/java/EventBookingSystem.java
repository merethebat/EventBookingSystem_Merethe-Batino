// Author: Merethe Batino
// Project: Event Booking System

import java.util.ArrayList;
import java.util.List;

public class EventBookingSystem {
    private final List<Event> events = new ArrayList<>();

    public boolean createEvent(String name, int capacity) {
        if (name == null || name.isBlank() || capacity <= 0 || findEvent(name) != null) {
            return false;
        }
        events.add(new Event(name, capacity));
        return true;
    }

    public Event findEvent(String name) {
        if (name == null) {
            return null;
        }
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public boolean registerAttendee(String eventName, String attendeeName) {
        Event event = findEvent(eventName);
        return event != null && event.registerAttendee(attendeeName);
    }

    public boolean cancelRegistration(String eventName, String attendeeName) {
        Event event = findEvent(eventName);
        return event != null && event.cancelRegistration(attendeeName);
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }
}
