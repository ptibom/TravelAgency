package se.computerscience.travelagency.view.admin;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.IPlaneDAO;
import se.computerscience.travelagency.model.persistence.Plane;

/**
 *
 * @author Hossein
 */
@Named(value = "planeBean")
@RequestScoped
public class PlaneBean {
    
    @EJB
    private IPlaneDAO planeDAO;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String type;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String pid;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String capacity;
    
    public List<Plane> allPlanes(){
        return planeDAO.findAll();
    }
}
