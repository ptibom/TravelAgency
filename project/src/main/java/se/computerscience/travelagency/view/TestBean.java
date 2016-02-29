package se.computerscience.travelagency.view;


import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import org.primefaces.component.steps.Steps;
 
@SessionScoped
@Named("testBean")
public class TestBean implements Serializable {
 
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
        
          public void changeTab(Steps event) 
    {   
       System.out.println("I was run even");
        event.setActiveIndex(3);
    }

}