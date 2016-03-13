package se.computerscience.travelagency.view;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;

/**
 *
 * @author Hossein
 */
@Named(value = "hotelBean")
@ManagedBean
@SessionScoped
public class HotelBean {
    
    @EJB
    private IHotelDAO hotelDAO;
    @EJB
    private ICityDAO cityDAO;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String hotelIdEdit, hotelIdDel;
    
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String hotelDescriptionAdd, hotelDescriptionEdit, hotelDescriptionDel;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String hotelNameAdd, hotelNameEdit, hotelNameDel;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String hotelRoomsEdit, hotelRoomsDel, hotelRoomsAdd;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String hotelPriceEdit, hotelPriceDel, hotelPriceAdd;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String hotelRatingEdit, hotelRatingDel, hotelRatingAdd;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String cityIDEdit, cityIdDel, cityIdAdd;
    
    
    
    
    
    public String addHotel() {
        try {
            long cityId = Long.parseLong(cityIdAdd);
            City city = cityDAO.findById(cityId);
            
            if(city != null) {
                Hotel hotel = new Hotel();
                hotel.setDecsription(hotelDescriptionAdd);
                hotel.setName(hotelNameAdd);

                int nrRooms = Integer.parseInt(hotelRoomsAdd);
                double price = Double.parseDouble(hotelPriceAdd);
                int rating = Integer.parseInt(hotelRatingAdd);
                
                hotel.setNumberOfRooms(nrRooms);
                hotel.setPrice(price);
                hotel.setRating(0);
                hotel.setCity(city);

                hotelDAO.create(hotel);
            }
            
            
        } catch (Exception e) {
            System.err.println("error "+e);
        }
        
        return "index?faces-redirect=true";
    }
    public String editCity() {
        try {
            long id = Long.parseLong(hotelIdEdit);
            Hotel hotel = hotelDAO.findById(id);
            hotel.setDecsription(hotelDescriptionAdd);
            hotel.setName(hotelNameAdd);
            
            int nrRooms = Integer.parseInt(hotelRoomsAdd);
            double price = Double.parseDouble(hotelPriceAdd);
            int rating = Integer.parseInt(hotelRatingAdd);
            hotel.setNumberOfRooms(nrRooms);
            hotel.setPrice(price);
            hotel.setRating(0);
            
            hotelDAO.create(hotel);
        } catch (Exception e) {
            System.err.println("error "+e);
        }
        return "/admin/index?faces-redirect=true";
        
    }
    public String deleteCity() {
        try {
            Long id = Long.parseLong(cityIdDel);
            cityDAO.delete(id);
        } catch (Exception e) {
            System.out.println("failed to parse id @citybean:deleteCity");
        }
        return "index?faces-redirect=true";
    }
    
    public List<Hotel> allHotels(){
        return hotelDAO.findAll();
    }
}
