package se.computerscience.travelagency.view.admin;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
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
    
    public List<City> allCities(){
        return cityDAO.findAll();
    }
}
