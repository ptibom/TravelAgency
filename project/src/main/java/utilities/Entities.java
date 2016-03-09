package utilities;

import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.model.persistence.Plane;

/**
 *
 * @author Hossein
 * Entity name for all entities in the database
 */
public enum Entities {
    // List of all entities from the database
    person("Person", Person.class), 
    flight("Flight", Flight.class),
    booking("Booking", Booking.class),
    city("City", City.class),
    hotel("Hotel", Hotel.class),
    plane("Plane", Plane.class);
    
    public String type;
    public Class cls;

    private Entities(String type, Class cls) {
        this.type = type;
        this.cls = cls;
    }
}
