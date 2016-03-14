/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Person;

/**
 *
 * @author MonoMan
 */
@Named(value = "contactBB")
@SessionScoped
public class ContactBB implements Serializable {
  @Getter
    @Setter
    List<Person> passengerList;

    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String numPassengers;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp = "\\d+")
    @Size(min = 16, max = 16)
    private String creditCardNumber;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    private String cardHolderName;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String expirationDate;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String toCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String fromCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String hotelId;
     
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String outFlight;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String returnFlight;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String fromDate;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String toDate;
   
    
    public ContactBB() {   
    }
        // We initialize the passenger list to be filled out
    public List<Person> intializePassengerList() {
        System.out.println(numPassengers);
        passengerList = new ArrayList<>();

        if (numPassengers == null) {
            return null;
        }
        int passangers = Integer.parseInt(numPassengers);

        for (int i = 0; i < passangers; i++) {
            passengerList.add(new Person());
        }

        return passengerList;
    }
    

    public String toFormContactAndClear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("SessionBean1");
        return "/partials/booking/formContact.xhtml?faces-redirect=true&amp;includeViewParams=true";
    }
    
}
