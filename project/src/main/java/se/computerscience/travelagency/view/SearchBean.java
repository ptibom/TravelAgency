package se.computerscience.travelagency.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;

/**
 *
 * @author Philip
 */
@Named(value = "searchBean")
@ManagedBean
@ViewScoped
public class SearchBean {
    
    @EJB
    ICityDAO cityDAO;
    
    @EJB
    IHotelDAO hotelDAO;
    
    @EJB
    IFlightDAO flightDAO;
    
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
    @Pattern(regexp = "[1-3]", message = "Required: 1-3")
    private String sortBy;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    private String outboundFlightId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    private String returnFlightId;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    private String hotelId;
    
    @Getter
    @Setter
    private String direction;
 
    @PostConstruct
    public void init() {
        sortBy = "2";
        direction = "Outbound flight";
    }
    
    public List<String> searchCity(String query) {
        return cityDAO.searchCityByNameToString(query);
    }
    
    public List<Hotel> getAvailableHotels() {
        City city = cityDAO.cityByName(toCity);
        List<Hotel> hotels = hotelDAO.getAvailableHotels(fromDate, toDate, city, numPassengers);
        switch (sortBy) {
            case "1": 
                hotels = orderHotelByPrice(hotels);
                break;
            case "2": 
                hotels = orderHotelByRating(hotels);
                break;
            case "3": 
                hotels = orderHotelByName(hotels);
                break;
            default:
                hotels = orderHotelByPrice(hotels);
                break;
        }
        return hotels;
    }
    
    public List<Flight> getAvailableFlights() {
        City depCity;
        City arrCity;
        Date depDate;
        if (outboundFlightId == null) {
            depCity = cityDAO.cityByName(fromCity);
            arrCity = cityDAO.cityByName(toCity);
            depDate = fromDate;
        }
        else {
            depCity = cityDAO.cityByName(toCity);
            arrCity = cityDAO.cityByName(fromCity);
            depDate = toDate;
            direction = "Return flight";
        }
        
        System.out.println(depCity.getName());
        System.out.println(arrCity.getName());
        System.out.println(depDate.toString());
        
        List<Flight> flights = flightDAO.searchFlightByCities(depCity, arrCity, depDate);
        switch (sortBy) {
            case "1": 
                flights = orderFlightByPrice(flights);
                break;
            case "2": 
                flights = orderFlightByEarliest(flights);
                break;
            case "3": 
                flights = orderFlightByEarliest(flights);
                break;
            default:
                flights = orderFlightByDuration(flights);
                break;
        }
        return flights;
    }
    
    public List<Hotel> orderHotelByPrice(List<Hotel> hotels) {
        return hotelDAO.orderByPrice(hotels);
    }
    
    public List<Hotel> orderHotelByRating(List<Hotel> hotels) {
        return hotelDAO.orderByRating(hotels);
    }
    
    public List<Hotel> orderHotelByName(List<Hotel> hotels) {
        return hotelDAO.orderByName(hotels);
    }
    
    public List<Flight> orderFlightByPrice(List<Flight> flights) {
        return flightDAO.orderByPrice(flights);
    }
    
    public List<Flight> orderFlightByEarliest(List<Flight> flights) {
        return flightDAO.orderByEarliest(flights);
    }
    
    public List<Flight> orderFlightByDuration(List<Flight> flights) {
        return flightDAO.orderByDuration(flights);
    }
}
