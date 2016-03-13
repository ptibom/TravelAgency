package se.computerscience.travelagency.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;

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

    public AdminCtrl() {
    }
    
    public String addHotel() {
        try {
            long cId = Long.parseLong(this.cityId);
            City city = cityDAO.findById(cId);
            
            if(city != null) {
                Hotel hotel = new Hotel();
                hotel.setDecsription(description);
                hotel.setName(name);
                
                int nrRooms = Integer.parseInt(rooms);
                int numPrice = Integer.parseInt(price);
                int numRating = Integer.parseInt(rating);
                
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
            long cId = Long.parseLong(cityId);
            City city = cityDAO.findById(cId);
            
            if(city != null) {
                Long parsedId = Long.parseLong(hid);
                Hotel hotel = hotelDAO.findById(parsedId);
                hotel.setDecsription(description);
                hotel.setName(name);
                
                int nrRooms = Integer.parseInt(rooms);
                int numPrice = Integer.parseInt(price);
                int numRating = Integer.parseInt(rating);
                
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
            Long id = Long.parseLong(hid);
            hotelDAO.delete(id);
        } catch (Exception e) {
            System.out.println("error "+e);
        }
        return redir();
    }
    
    public List<Hotel> allHotels(){
        return hotelDAO.findAll();
    }

    public String redir() {
        name = null;
        rooms = null;
        description = null;
        price = null;
        rating = null;
        hid = null;
        cityId = null;
        
        return "index?faces-redirect=true";
    }
}
