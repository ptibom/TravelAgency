package se.computerscience.travelagency.model.persistence;

import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class BookingDAO extends GeneralDAO<Booking> implements IBookingDAO {
    public BookingDAO() {
        super(Booking.class);
    }
}
