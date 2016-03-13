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
    private String planeTypeAdd, planeTypeEdit, planeTypeDel;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String planeIdEdit, planeIdDel;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String planeCapacityEdit, planeCapacityDel, planeCapacityAdd;
    
    
    
    
    
    
    public String addPlane() {
        try {
            Plane plane = new Plane();
            int cap = Integer.parseInt(planeCapacityAdd);
            plane.setCapacity(cap);
            plane.setType(planeTypeAdd);
            planeDAO.create(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        
        return "index?faces-redirect=true";
    }
    public String editPlane() {
        try {
            Long id = Long.parseLong(planeIdEdit);
            int cap = Integer.parseInt(planeCapacityEdit);
            Plane plane = planeDAO.findById(id);
            plane.setCapacity(cap);
            plane.setType(planeTypeEdit);
            planeDAO.update(plane);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return "index?faces-redirect=true";        
    }
    public String deletePlane() {
        try {
            Long id = Long.parseLong(planeIdDel);
            planeDAO.delete(id);
        } catch (Exception e) {
            System.err.println("error"+e);
        }
        return "index?faces-redirect=true";
    }
    
    public List<Plane> allPlanes(){
        return planeDAO.findAll();
    }
}
