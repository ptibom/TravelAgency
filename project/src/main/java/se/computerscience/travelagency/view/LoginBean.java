package se.computerscience.travelagency.view;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.AdminUser;
import se.computerscience.travelagency.model.persistence.IAdminUserDAO;

/**
 *
 * @author Hossein
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    private IAdminUserDAO userDAO;
    
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(userName, password);
            AdminUser user = userDAO.findByIDandPw(userName, password).get(0);
            if (user == null) {
                return "";
            }
            externalContext.getSessionMap().put("admin", user);
            return "/admin/index?faces-redirect=true";
        } catch (ServletException e) {
            System.err.println("Logg in failed");
            return "";
        }
    }

    public void logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
    }
}
