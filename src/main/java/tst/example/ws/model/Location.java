package tst.example.ws.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Location {
    LOCATION1("Location1", 1),
    LOCATION2("Location2", 2),
    LOCATION3("Location3", 3),
    LOCATION4("Location4", 4),
    LOCATION5("Location5", 5);
    private final String location;
    private final int priority;
    Location(String location, int priority) {
        this.location = location;
        this.priority = priority;
    }

}
