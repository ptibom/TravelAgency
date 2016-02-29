package se.computerscience.travelagency.view;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import org.primefaces.component.steps.Steps;
 
@ManagedBean
@SessionScoped
public class TestBean implements Serializable {
 
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
        
          public void changeTab() 
    {   
        System.out.println ("Testing...");
        
        //Steps tabView = (Steps) event.getComponent();
       // tabView.setActiveIndex(3);
    }

}