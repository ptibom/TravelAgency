package se.computerscience.travelagency.model.persistence;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Hossein
 */
public interface IFlightDAO extends IDAO<Flight> {
    public List<Flight> searchFlightByCities(City dep, City des, Date depature);
    public List<Flight> orderByPrice(List<Flight> flightList);
    public List<Flight> orderByDuration(List<Flight> flightList);
    public List<Flight> orderByPriceAndDuration(List<Flight> flightList);
    public List<Flight> orderByEarliest(List<Flight> flightList);
    public List<Flight> orderByLatest(List<Flight> flightList);
    
}
