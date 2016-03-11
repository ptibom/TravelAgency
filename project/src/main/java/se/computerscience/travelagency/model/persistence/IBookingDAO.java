package se.computerscience.travelagency.model.persistence;

import java.util.List;

/**
 *
 * @author Hossein
 */
public interface IBookingDAO extends IDAO<Booking> {
    public List<Person> getPassengers ();
}
