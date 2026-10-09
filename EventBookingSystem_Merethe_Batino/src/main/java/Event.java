// Author: Merethe Batino
// Project: Event Booking System

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final String name;
    private final int capacity;
    private final List<String> attendees = new ArrayList<>();

    public Event(String name, int capacity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Event name cannot be empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getAttendees() {
        return new ArrayList<>(attendees);
    }

    public int getAvailableSeats() {
        return capacity - attendees.size();
    }

    public boolean registerAttendee(String attendeeName) {
        if (attendeeName == null || attendeeName.isBlank()) {
            return false;
        }
        if (attendees.contains(attendeeName) || attendees.size() >= capacity) {
            return false;
        }
        attendees.add(attendeeName);
        return true;
    }

    public boolean cancelRegistration(String attendeeName) {
        if (attendeeName == null || attendeeName.isBlank()) {
            return false;
        }
        return attendees.remove(attendeeName);
    }

    @Override
    public String toString() {
        return name + " - " + attendees.size() + "/" + capacity + " seats booked";
    }
}
