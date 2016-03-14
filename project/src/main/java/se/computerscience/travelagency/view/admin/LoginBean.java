package se.computerscience.travelagency.view.admin;

import java.io.Serializable;
import java.util.List;
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
            List<AdminUser> adminList = userDAO.findByIDandPw(userName, password);
            if (adminList.size() < 1) {
                System.err.println("1");
                logout();
                return "login?faces-redirect=true";
            }
            AdminUser user = userDAO.findByIDandPw(userName, password).get(0);
            if (user == null) {
                System.err.println("2");
                logout();
                return "login?faces-redirect=true";
            }
            externalContext.getSessionMap().put("admin", user);
            System.err.println("3");
            return "/admin/index?faces-redirect=true";
        } catch (ServletException e) {
            System.err.println("Logg in failed");
            return "";
        } catch (NullPointerException e) {
            System.err.println("this account does not exist");
            return "";
        }
    }

    public void logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
    }
}
