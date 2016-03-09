package se.computerscience.travelagency.model.persistence;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class HotelDAO extends GeneralDAO<Hotel> implements IHotelDAO {
    public HotelDAO() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> searchByDate(Date arrivalDate, Date returnDate, Hotel hotel) {   
        return em.createQuery("SELECT t FROM Booking t WHERE t.hotel = :hotel AND t.flyToDate >= :arrivalDate AND t.flyBackDate <= :returnDate")
                .setParameter("hotel", hotel)
                .setParameter("arrivalDate", arrivalDate)
                .setParameter("returnDate", returnDate)
                .getResultList();
    }
}
