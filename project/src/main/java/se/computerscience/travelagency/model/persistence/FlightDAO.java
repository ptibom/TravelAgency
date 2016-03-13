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
    public List<Flight> searchFlightByCities(City depCity, City desCity, Date depDate) {
        return em.createQuery("SELECT t FROM Flight t WHERE t.desCity = :desCity AND t.depCity = :depCity AND CAST(t.depature AS DATE) = :depDate order by t.price")
                .setParameter("desCity", desCity)
                .setParameter("depCity", depCity)
                .setParameter("depDate", depDate)
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
