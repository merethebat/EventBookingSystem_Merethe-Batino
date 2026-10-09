# Event Booking System

**Author: Merethe Batino**

## About the project
This is a small Java console program for creating events and managing attendee registrations. An event has a name and a seat limit. People can register for an event or cancel a registration.

## Features
- Create events
- View events and booked seats
- Register attendees
- Stop duplicate registrations and bookings over capacity
- Cancel a registration
- Reuse a seat after someone cancels

## Requirements
- Java 21
- Maven
- JUnit 5 (included as a Maven test dependency)

JUnit 5 is included from Maven Central through the dependency in `pom.xml`.

## Run the program
From the project folder, run:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="Main"
```

If the exec command is not available in your Maven setup, you can run `Main.java` from your IDE after importing the project as a Maven project.

## Run the tests
```bash
mvn test
```

The tests cover valid and invalid event creation, duplicate event names, finding events, attendee registration, capacity limits, duplicate registrations, cancellations, available seats, and protecting the attendee list from outside changes.

## Clean code examples
1. **Separate classes:** `Event` stores the event details and registrations, while `EventBookingSystem` manages the list of events. `Main` handles the console menu.
2. **Small methods:** Methods such as `registerAttendee`, `cancelRegistration`, and `findEvent` each handle one main task.
3. **Meaningful names:** Names like `getAvailableSeats` and `cancelRegistration` describe what the methods do.
4. **Input checks:** Event creation and registration check for blank names, invalid capacity, duplicate events, and full events.

Add screenshots from your own run to this section before submitting:
- Screenshot of the program running in the terminal
- Screenshot of JUnit tests passing
- Screenshot showing a clean-code example in your editor

## Git workflow
Use a feature branch and pull request so the repository shows the workflow required for the QAP. Example commands:

```bash
git checkout -b feature/event-registration
git add .
git commit -m "Add event registration features"
git push -u origin feature/event-registration
```

Open a pull request on GitHub and merge it into `main` after reviewing it. Make additional small commits for tests, documentation, and workflow setup as you work.

## Problems encountered
Fill this in with any real problems you ran into while building or testing the project. For example, mention a Maven or Java setup issue only if you actually experienced it.
