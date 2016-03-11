package se.computerscience.travelagency.model.persistence;

import java.util.List;
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
    
    @Override
    public List<Person> getPassengers(){
        
          return em.createQuery("SELECT t FROM Booking t")
                .getResultList();
    }
    
     @Override
    public void  insertBooking(List<Person> passengers, Booking booking ){
        
          em.createQuery("INSERT INTO BOOKING" + "VALUES (" + booking.getFlyBack() + ", " + booking.getFlyTo() + ", " + booking.getPrice().toString() + ")" );
        
      //  for(Person passenger:passengers)
      //    em.createQuery("INSERT INTO PERSON" + "VALUES (" )
                
    }
}
