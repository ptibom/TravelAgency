package se.computerscience.travelagency.model.persistence;

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
        return em.createQuery("SELECT t FROM Flight t WHERE t.desCity = :des AND t.depCity = :dep AND t.depature = :depature")
                .setParameter("des", des)
                .setParameter("dep", dep)
                .setParameter("depature", depature)
                .getResultList();
    }
}
