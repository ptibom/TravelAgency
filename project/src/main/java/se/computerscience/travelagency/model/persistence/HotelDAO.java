package se.computerscience.travelagency.model.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
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
    
    @Override
    public List<Hotel> getAvailableHotels(Date arrivalDate, Date returnDate, City city, String persons) {
        int numPersons = 0;
        try {
            numPersons = Integer.parseInt(persons);
        }
        catch(NumberFormatException e) {
            List<Hotel> emptyList = new ArrayList<>();
            return emptyList; // Exit the request.
        }
        
        List<Hotel> availableHotels = new LinkedList<>();
        List<Hotel> hotelList = city.getHotelList();
        for (Hotel hotel : hotelList) {
            int numBookedRooms = searchByDate(arrivalDate, arrivalDate, hotel).size();
            if ((hotel.getNumberOfRooms() - numBookedRooms) >= (numPersons/2)) {
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }
    
    @Override
    public List<Hotel> orderByRating(List<Hotel> hotelList) {
        Collections.sort(hotelList, Hotel.Comparators.RATING);
        return hotelList;
    }
    
    @Override
    public List<Hotel> orderByName(List<Hotel> hotelList) {
        Collections.sort(hotelList, Hotel.Comparators.NAME);
        return hotelList;
    }
    
    @Override
    public List<Hotel> orderByPrice(List<Hotel> hotelList) {
        Collections.sort(hotelList, Hotel.Comparators.PRICE);
        return hotelList;
    }
    
    @Override
    public List<Hotel> orderByRatingAndPrice(List<Hotel> hotelList) {
        Collections.sort(hotelList, Hotel.Comparators.RATINGandPRICE);
        return hotelList;
    }

}
