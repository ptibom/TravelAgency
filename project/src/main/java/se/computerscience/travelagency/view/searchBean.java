package se.computerscience.travelagency.view;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Future;
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
 * @author Philip
 */
@Named(value = "searchBean")
@ManagedBean
@RequestScoped
public class searchBean {
    
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
    
    public List<String> searchCity(String query) {
        return cityDAO.searchCityByNameToString(query);
    }
    public List<Hotel> getAvailableHotels () {
        City city = cityDAO.cityByName(toCity);
        List<Hotel> hotels = hotelDAO.getAvailableHotels(fromDate, toDate, city, numPassengers);
        System.out.println(hotels.size());
        return hotels;
    }
    
    public List<Hotel> orderByPrice(List<Hotel> hotelList) {
        return hotelDAO.orderByPrice(hotelList);
    }
    
    public List<Hotel> orderByRating(List<Hotel> hotelList) {
        return hotelDAO.orderByRating(hotelList);
    }
    
    public List<Hotel> orderByPopularity(List<Hotel> hotelList) {
        return hotelDAO.orderByRatingAndPrice(hotelList);
    }
}
