package se.computerscience.travelagency.view;

import java.util.List;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.Hotel;

import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.IPersonDAO;
import se.computerscience.travelagency.model.persistence.Person;

/**
 *
 * @author Hossein
 */
@Named(value = "bookingBean")
@ManagedBean
@ViewScoped
public class BookingBean {
    
    @EJB
    private ICityDAO cityDAO;
    @EJB
    private IBookingDAO bookingDAO;
    @EJB
    private IFlightDAO flightDAO;
    @EJB
    private IHotelDAO hotelDAO;
    @EJB
    private IPersonDAO personDAO;
    
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String id;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date depatureToDate;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date depatureBackDate;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String price;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String depCityId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String desCityId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String flightToId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String flightBackId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String hotelId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String personId;
    
    
    public String addBooking() {
        Booking booking = new Booking();
        
        long parsedId = Long.parseLong(depCityId);
        City depCity = cityDAO.findById(parsedId);
        
        parsedId = Long.parseLong(desCityId);
        City desCity = cityDAO.findById(parsedId);
        
        parsedId = Long.parseLong(flightBackId);
        Flight flyBack = flightDAO.findById(parsedId);
        
        parsedId = Long.parseLong(flightToId);
        Flight flyTo = flightDAO.findById(parsedId);
        
        parsedId = Long.parseLong(hotelId);
        Hotel hotel = hotelDAO.findById(parsedId);
        
        parsedId = Long.parseLong(personId);
        Person person = personDAO.findById(parsedId);
        
        int parsedPrice = Integer.parseInt(price);
        
        // check if any of the above is invalid, then return
        if (depCity == null || desCity == null || flyBack == null || flyTo == null || hotel == null || person == null) {
            System.err.println("failed check for not null @bookingBean");
            return redir();
        }
        booking.setDepCity(depCity);
        booking.setDesCity(desCity);
        booking.setFlyBack(flyBack);
        booking.setFlyTo(flyTo);
        booking.setFlyBackDate(depatureBackDate);
        booking.setFlyToDate(depatureToDate);
        booking.setHotel(hotel);
        booking.setPrice(parsedPrice);
        booking.setPerson(person);
        
        bookingDAO.create(booking);
        return redir();
    }
    public String editBooking() {
        try {
            long parsedId = Long.parseLong(id);
            Booking booking = bookingDAO.findById(parsedId);
        
            parsedId = Long.parseLong(depCityId);
            City depCity = cityDAO.findById(parsedId);

            parsedId = Long.parseLong(desCityId);
            City desCity = cityDAO.findById(parsedId);

            parsedId = Long.parseLong(flightBackId);
            Flight flyBack = flightDAO.findById(parsedId);

            parsedId = Long.parseLong(flightToId);
            Flight flyTo = flightDAO.findById(parsedId);

            parsedId = Long.parseLong(hotelId);
            Hotel hotel = hotelDAO.findById(parsedId);

            parsedId = Long.parseLong(personId);
            Person person = personDAO.findById(parsedId);

            int parsedPrice = Integer.parseInt(price);

            // check if any of the above is invalid, then return
            if (depCity == null || desCity == null || flyBack == null || flyTo == null || hotel == null || person == null || booking == null) {
                System.err.println("failed check for not null @bookingBean");
                return redir();
            }
            booking.setDepCity(depCity);
            booking.setDesCity(desCity);
            booking.setFlyBack(flyBack);
            booking.setFlyTo(flyTo);
            booking.setFlyBackDate(depatureBackDate);
            booking.setFlyToDate(depatureToDate);
            booking.setHotel(hotel);
            booking.setPrice(parsedPrice);
            booking.setPerson(person);

            bookingDAO.update(booking);
            return redir();
            
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
        
    }
    public String deleteBooking() {
        try {
            Long parsedId = Long.parseLong(id);
            bookingDAO.delete(parsedId);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
    }
    public String redir() {

        return "index?faces-redirect=true";
    }
    
    public List<Booking> allBookings(){
        return bookingDAO.findAll();
    }
}
