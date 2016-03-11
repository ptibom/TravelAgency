package se.computerscience.travelagency.model.persistence;

import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<Flight> searchFlightByCities(City dep, City des, Date depature) {
        return em.createQuery("SELECT t FROM Flight t WHERE t.desCity = :des AND t.depCity = :dep AND t.depature = :depature order by t.price")
                .setParameter("des", des)
                .setParameter("dep", dep)
                .setParameter("depature", depature)
                .getResultList();
    }

    @Override
    public List<Flight> orderByPrice(List<Flight> flightList) {
        Collections.sort(flightList, Flight.Comparators.PRICE);
        return flightList;
    }

    @Override
    public List<Flight> orderByDuration(List<Flight> flightList) {
        Collections.sort(flightList, Flight.Comparators.FLIGHT_TIME);
        return flightList;
    }

    @Override
    public List<Flight> orderByPriceAndDuration(List<Flight> flightList) {
        Collections.sort(flightList, Flight.Comparators.PRICEandTIME);
        return flightList;
    }

    @Override
    public List<Flight> orderByEarliest(List<Flight> flightList) {
        Collections.sort(flightList, Flight.Comparators.EARLIEST);
        return flightList;
    }

    @Override
    public List<Flight> orderByLatest(List<Flight> flightList) {
        Collections.sort(flightList, Flight.Comparators.LATEST);
        return flightList;
    }
}
