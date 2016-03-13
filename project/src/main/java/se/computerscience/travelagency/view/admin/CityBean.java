package se.computerscience.travelagency.view.admin;

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
import se.computerscience.travelagency.model.persistence.ICityDAO;

/**
 *
 * @author Hossein
 */
@Named(value = "cityBean")
@ManagedBean
@SessionScoped
public class CityBean {
    
    @EJB
    private ICityDAO cityDAO;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String name;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String id;
    
    
    
    
    public String addCity() {
        City city = new City();
        city.setName(name);
        cityDAO.create(city);
        return redir();
    }
    public String editCity() {
        try {
            Long parsedId = Long.parseLong(id);
            City city = cityDAO.findById(parsedId);
            city.setName(name);
            cityDAO.update(city);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
        
    }
    public String deleteCity() {
        try {
            Long parsedId = Long.parseLong(id);
            cityDAO.delete(parsedId);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return redir();
    }
    public String redir() {
        name = null;
        return "index?faces-redirect=true";
    }
    
    public List<City> allCities(){
        return cityDAO.findAll();
    }
}
