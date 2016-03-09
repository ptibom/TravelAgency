package se.computerscience.travelagency.model.persistence;

import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class FlightDAO extends GeneralDAO<Flight> implements IFlightDAO{
    public FlightDAO() {
        super(Flight.class);
    }
}
