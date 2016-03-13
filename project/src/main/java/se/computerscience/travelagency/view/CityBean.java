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
    private String cityNameAdd, cityNameEdit, cityNameDel;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String cityIdEdit, cityIdDel;
    
    
    
    
    public String addCity() {
        City city = new City();
        city.setName(cityNameAdd);
        cityDAO.create(city);
        cityNameAdd=""; // make it empty again
        return "index?faces-redirect=true";
    }
    public String editCity() {
        try {
            Long id = Long.parseLong(cityIdEdit);
            City city = cityDAO.findById(id);
            city.setName(cityNameEdit);
            cityDAO.update(city);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            System.out.println("failed to parse id @citybean:editCity");
            return "/admin/index?faces-redirect=true";
        }
        
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
    
    public List<City> allCities(){
        return cityDAO.findAll();
    }
}
