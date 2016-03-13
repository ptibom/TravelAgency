package se.computerscience.travelagency.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.view.admin.HotelBean;

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
    
    private HotelBean hotelBean;

    public AdminCtrl() {
    }
    
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
            Long id = Long.parseLong(hotelBean.getRooms());
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
        return "index?faces-redirect=true";
    }
    
    @Inject
    public void setHotelBean(HotelBean hotelBean) {
        this.hotelBean = hotelBean;
    }
}
