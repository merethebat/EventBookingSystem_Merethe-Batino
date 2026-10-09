// Author: Merethe Batino
// Tests for the Event Booking System

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EventBookingSystemTest {
    private final EventBookingSystem system = new EventBookingSystem();


    @Test
    void createsEventWithValidDetails() {
        assertTrue(system.createEvent("Merethe's Workshop", 10));
    }

    @Test
    void doesNotCreateEventWithBlankName() {
        assertFalse(system.createEvent("Merethe's Workshop", 10));
    }

    @Test
    void doesNotCreateEventWithZeroCapacity() {
        assertFalse(system.createEvent("Meetup", 0));
    }

    @Test
    void doesNotCreateDuplicateEventName() {
        system.createEvent("Dianne's Study Group", 5);
        assertFalse(system.createEvent("Dianne's Study Group", 8));
    }

    @Test
    void findsEventWithoutCaseSensitivity() {
        system.createEvent("Coding Night", 5);
        assertNotNull(system.findEvent("Coding Night"));
    }

    @Test
    void returnsNullWhenEventDoesNotExist() {
        assertNull(system.findEvent("Missing Event"));
    }

    @Test
    void registersAttendeeForExistingEvent() {
        system.createEvent("Workshop", 2);
        assertTrue(system.registerAttendee("Workshop", "Alex"));
    }

    @Test
    void preventsDuplicateAttendeeRegistration() {
        system.createEvent("Workshop", 3);
        system.registerAttendee("Workshop", "Alex");
        assertFalse(system.registerAttendee("Workshop", "Alex"));
    }

    @Test
    void preventsRegistrationWhenEventIsFull() {
        system.createEvent("Workshop", 1);
        system.registerAttendee("Workshop", "Alex");
        assertFalse(system.registerAttendee("Workshop", "Sam"));
    }

    @Test
    void preventsRegistrationForUnknownEvent() {
        assertFalse(system.registerAttendee("Unknown", "Alex"));
    }

    @Test
    void cancelsExistingRegistration() {
        system.createEvent("Workshop", 2);
        system.registerAttendee("Workshop", "Alex");
        assertTrue(system.cancelRegistration("Workshop", "Alex"));
    }

    @Test
    void cannotCancelRegistrationThatDoesNotExist() {
        system.createEvent("Workshop", 2);
        assertFalse(system.cancelRegistration("Workshop", "Alex"));
    }

    @Test
    void cancelledSeatCanBeBookedAgain() {
        system.createEvent("Workshop", 1);
        system.registerAttendee("Workshop", "Alex");
        system.cancelRegistration("Workshop", "Alex");
        assertTrue(system.registerAttendee("Workshop", "Sam"));
    }

    @Test
    void reportsAvailableSeatsCorrectly() {
        Event event = new Event("Workshop", 4);
        event.registerAttendee("Alex");
        event.registerAttendee("Sam");
        assertEquals(2, event.getAvailableSeats());
    }

    @Test
    void attendeeListIsNotDirectlyModifiable() {
        Event event = new Event("Workshop", 3);
        event.registerAttendee("Alex");
        event.getAttendees().clear();
        assertEquals(1, event.getAttendees().size());
    }
}
