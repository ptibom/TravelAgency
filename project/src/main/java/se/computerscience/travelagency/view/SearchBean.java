package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.Person;

/**
 *
 * @author Philip
 */
@Named(value = "searchBean")
@ManagedBean
@SessionScoped
public class SearchBean implements Serializable{
    
    @EJB
    ICityDAO cityDAO;
    
    @EJB
    IHotelDAO hotelDAO;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String fromCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String toCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String numPassengers;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date fromDate;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date toDate;
    
    @Getter
    @Setter
    @Pattern(regexp = "[1-3]")
    private String sortBy;
   
    @PostConstruct
    public void init() {
        sortBy = "2";
    }
    
    public List<String> searchCity(String query) {
        return cityDAO.searchCityByNameToString(query);
    }
    public List<Hotel> getAvailableHotels() {
        City city = cityDAO.cityByName(toCity);
        List<Hotel> hotels = hotelDAO.getAvailableHotels(fromDate, toDate, city, numPassengers);
        switch (sortBy) {
            case "1": 
                System.out.println("ByPrice");
                hotels = orderByPrice(hotels);
                break;
            case "2": 
                System.out.println("ByRating");
                hotels = orderByRating(hotels);
                break;
            case "3": 
                System.out.println("orderByName");
                hotels = orderByName(hotels);
                break;
            default:
                System.out.println("ByPrice");
                hotels = orderByPrice(hotels);
                break;
        }
        System.out.println(hotels.get(0).getName());
        return hotels;
    }
    
    public List<Hotel> orderByPrice(List<Hotel> hotels) {
        return hotelDAO.orderByPrice(hotels);
    }
    
    public List<Hotel> orderByRating(List<Hotel> hotels) {
        return hotelDAO.orderByRating(hotels);
    }
    
    public List<Hotel> orderByName(List<Hotel> hotels) {
        return hotelDAO.orderByName(hotels);
    }
    

    public void clear(){
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
