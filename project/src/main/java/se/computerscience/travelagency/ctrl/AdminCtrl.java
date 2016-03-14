package se.computerscience.travelagency.ctrl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.IPersonDAO;
import se.computerscience.travelagency.model.persistence.IPlaneDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.model.persistence.Plane;
import se.computerscience.travelagency.view.admin.BookingBean;
import se.computerscience.travelagency.view.admin.CityBean;
import se.computerscience.travelagency.view.admin.HotelBean;
import se.computerscience.travelagency.view.admin.PlaneBean;

/**
 *
 * @author Philip Tibom
 */
@Named(value = "adminCtrl")
@RequestScoped
public class AdminCtrl {
    
    @EJB
    private IHotelDAO hotelDAO;
    
    @EJB
    private ICityDAO cityDAO;
    
    @EJB
    private IPlaneDAO planeDAO;
    
    @EJB
    private IFlightDAO flightDAO;
    
    @EJB
    private IBookingDAO bookingDAO;
    
    @EJB
    private IPersonDAO personDAO;
    
    private HotelBean hotelBean;
    private CityBean cityBean;
    private PlaneBean planeBean;
    private BookingBean bookingBean;
    

    public AdminCtrl() {
    }
    
    @Inject
    public void setHotelBean (HotelBean hotelBean) {
        this.hotelBean = hotelBean;
    }
    
    @Inject
    public void setCityBean (CityBean cityBean) {
        this.cityBean = cityBean;
    }
    
    @Inject
    public void setPlaneBean (PlaneBean planeBean) {
        this.planeBean = planeBean;
    }
    
    @Inject
    public void setBookingBean (BookingBean bookingBean) {
        this.bookingBean = bookingBean;
    }
    
    
    /*
     Hotel methods
     */
    public String addHotel() {
        try {
            long cId = Long.parseLong(hotelBean.getCityId());
            City city = cityDAO.findById(cId);
            
            if(city != null) {
                Hotel hotel = new Hotel();
                hotel.setDecsription(hotelBean.getDescription());
                hotel.setName(hotelBean.getName());
                
                int nrRooms = Integer.parseInt(hotelBean.getRooms());
                int numPrice = Integer.parseInt(hotelBean.getPrice());
                int numRating = Integer.parseInt(hotelBean.getRating());
                
                hotel.setNumberOfRooms(nrRooms);
                hotel.setPrice(numPrice);
                hotel.setRating(numRating);
                hotel.setCity(city);
                hotelDAO.create(hotel);
            }            
        } catch (Exception e) {
            System.err.println("error "+e);
        }
        
        return redir();
    }
    
    public String editHotel() {
        try {
            long cId = Long.parseLong(hotelBean.getCityId());
            City city = cityDAO.findById(cId);
            
            if(city != null) {
                Long parsedId = Long.parseLong(hotelBean.getHid());
                Hotel hotel = hotelDAO.findById(parsedId);
                hotel.setDecsription(hotelBean.getDescription());
                hotel.setName(hotelBean.getName());
                
                int nrRooms = Integer.parseInt(hotelBean.getRooms());
                int numPrice = Integer.parseInt(hotelBean.getPrice());
                int numRating = Integer.parseInt(hotelBean.getRating());
                
                hotel.setNumberOfRooms(nrRooms);
                hotel.setPrice(numPrice);
                hotel.setRating(numRating);
                hotel.setCity(city);
                hotelDAO.update(hotel);
            }
        } catch (Exception e) {
            System.err.println("error "+e);
        }
        return redir();
        
    }
    
    public String deleteHotel() {
        try {
            Long id = Long.parseLong(hotelBean.getHid());
            hotelDAO.delete(id);
        } catch (Exception e) {
            System.out.println("error "+e);
        }
        return redir();
    }
    
    /*
     City methods
     */
    
    public String addCity() {
        City city = new City();
        city.setName(cityBean.getName());
        cityDAO.create(city);
        return redir();
    }
    
    public String editCity() {
        try {
            Long parsedId = Long.parseLong(cityBean.getId());
            City city = cityDAO.findById(parsedId);
            city.setName(cityBean.getName());
            cityDAO.update(city);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
        
    }
    public String deleteCity() {
        try {
            Long parsedId = Long.parseLong(cityBean.getId());
            cityDAO.delete(parsedId);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
    }
    
    /*
    Plane methods
    */
    
    public String addPlane() {
        try {
            Plane plane = new Plane();
            int cap = Integer.parseInt(planeBean.getCapacity());
            plane.setCapacity(cap);
            plane.setType(planeBean.getType());
            planeDAO.create(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        
        return redir();
    }
    
    public String editPlane() {
        try {
            Long id = Long.parseLong(planeBean.getPid());
            int cap = Integer.parseInt(planeBean.getCapacity());
            Plane plane = planeDAO.findById(id);
            plane.setCapacity(cap);
            plane.setType(planeBean.getType());
            planeDAO.update(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return redir();       
    }
    
    public String deletePlane() {
        try {
            Long id = Long.parseLong(planeBean.getPid());
            planeDAO.delete(id);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return redir();
    }
    
    /*
    Booking methods
    */
    public String addBooking() {
        Booking booking = new Booking();
        
        long parsedId = Long.parseLong(bookingBean.getDepCityId());
        City depCity = cityDAO.findById(parsedId);
        
        parsedId = Long.parseLong(bookingBean.getDesCityId());
        City desCity = cityDAO.findById(parsedId);
        
        parsedId = Long.parseLong(bookingBean.getFlightBackId());
        Flight flyBack = flightDAO.findById(parsedId);
        
        parsedId = Long.parseLong(bookingBean.getFlightToId());
        Flight flyTo = flightDAO.findById(parsedId);
        
        parsedId = Long.parseLong(bookingBean.getHotelId());
        Hotel hotel = hotelDAO.findById(parsedId);
        
        parsedId = Long.parseLong(bookingBean.getPersonId());
        Person person = personDAO.findById(parsedId);
        
        int parsedPrice = Integer.parseInt(bookingBean.getPrice());
        
        // check if any of the above is invalid, then return
        if (depCity == null || desCity == null || flyBack == null || flyTo == null || hotel == null || person == null) {
            System.err.println("failed check for not null @bookingBean");
            return redir();
        }
        booking.setDepCity(depCity);
        booking.setDesCity(desCity);
        booking.setFlyBack(flyBack);
        booking.setFlyTo(flyTo);
        booking.setFlyBackDate(bookingBean.getDepatureBackDate());
        booking.setFlyToDate(bookingBean.getDepatureToDate());
        booking.setHotel(hotel);
        booking.setPrice(parsedPrice);
        // booking.setPersons(person);
        bookingDAO.create(booking);
        return redir();
    }
    
    public String editBooking() {
        try {
            long parsedId = Long.parseLong(bookingBean.getId());
            Booking booking = bookingDAO.findById(parsedId);
        
            parsedId = Long.parseLong(bookingBean.getDepCityId());
            City depCity = cityDAO.findById(parsedId);

            parsedId = Long.parseLong(bookingBean.getDesCityId());
            City desCity = cityDAO.findById(parsedId);

            parsedId = Long.parseLong(bookingBean.getFlightBackId());
            Flight flyBack = flightDAO.findById(parsedId);

            parsedId = Long.parseLong(bookingBean.getFlightToId());
            Flight flyTo = flightDAO.findById(parsedId);

            parsedId = Long.parseLong(bookingBean.getHotelId());
            Hotel hotel = hotelDAO.findById(parsedId);

            parsedId = Long.parseLong(bookingBean.getPersonId());
            Person person = personDAO.findById(parsedId);

            int parsedPrice = Integer.parseInt(bookingBean.getPersonId());

            // check if any of the above is invalid, then return
            if (depCity == null || desCity == null || flyBack == null || flyTo == null || hotel == null || person == null || booking == null) {
                System.err.println("failed check for not null @bookingBean");
                return redir();
            }
            booking.setDepCity(depCity);
            booking.setDesCity(desCity);
            booking.setFlyBack(flyBack);
            booking.setFlyTo(flyTo);
            booking.setFlyBackDate(bookingBean.getDepatureBackDate());
            booking.setFlyToDate(bookingBean.getDepatureToDate());
            booking.setHotel(hotel);
            booking.setPrice(parsedPrice);
            // booking.setPerson(person);

            bookingDAO.update(booking);
            return redir();
            
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
    }
    
    public String deleteBooking() {
        try {
            Long parsedId = Long.parseLong(bookingBean.getId());
            bookingDAO.delete(parsedId);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
    }
    
    public String redir() {        
        return "index?faces-redirect=true";
    }
    
}
