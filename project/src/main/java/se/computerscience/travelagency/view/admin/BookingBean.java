package se.computerscience.travelagency.view.admin;

import java.util.List;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.IPersonDAO;

/**
 *
 * @author Hossein
 */
@Named(value = "bookingAdminBean")
@RequestScoped
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
    
    public List<Booking> allBookings(){
        return bookingDAO.findAll();
    }
}
