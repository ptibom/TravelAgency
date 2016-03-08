/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.text.SimpleDateFormat;
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
        /*
        return em.createNativeQuery("SELECT * FROM SearchHotelByDate WHERE city = ? AND arrival >= ? AND depature <= ?")
                .setParameter(1, city.getId())
                .setParameter(2, arrivalDate)
                .setParameter(3, returnDate)
                .getResultList();
        */
        System.out.println("Hotel"+hotel.getId());
        System.out.println("arrivalDate "+arrivalDate.toString());
        System.out.println("returnDate "+returnDate.toString());
        return em.createQuery("SELECT t FROM Booking t WHERE t.hotel = :hotel AND t.flyToDate >= :arrivalDate AND t.flyBackDate <= :returnDate")
                .setParameter("hotel", hotel)
                .setParameter("arrivalDate", arrivalDate)
                .setParameter("returnDate", returnDate)
                .getResultList();
    }
}
