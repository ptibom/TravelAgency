package se.computerscience.travelagency.model.persistence;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Hossein
 */
public interface IFlightDAO extends IDAO<Flight> {
    public List<Flight> searchFlightByCities(City dep, City des, Date depature);
    
    
}
