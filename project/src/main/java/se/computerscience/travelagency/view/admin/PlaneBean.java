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
import se.computerscience.travelagency.model.persistence.IPlaneDAO;
import se.computerscience.travelagency.model.persistence.Plane;

/**
 *
 * @author Hossein
 */
@Named(value = "planeBean")
@ManagedBean
@SessionScoped
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
    
    
    
    
    
    
    public String addPlane() {
        try {
            Plane plane = new Plane();
            int cap = Integer.parseInt(capacity);
            plane.setCapacity(cap);
            plane.setType(type);
            planeDAO.create(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        
        return redir();
    }
    public String editPlane() {
        try {
            Long id = Long.parseLong(pid);
            int cap = Integer.parseInt(capacity);
            Plane plane = planeDAO.findById(id);
            plane.setCapacity(cap);
            plane.setType(type);
            planeDAO.update(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return redir();       
    }
    public String deletePlane() {
        try {
            Long id = Long.parseLong(pid);
            planeDAO.delete(id);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return redir();
    }
    public String redir() {
        capacity = null;
        type = null;
        return "index?faces-redirect=true";
    }
    public List<Plane> allPlanes(){
        return planeDAO.findAll();
    }
}
