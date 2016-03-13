/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Person;

@Named(value = "bookingBean")
@ManagedBean
@SessionScoped
public class BookingBean implements Serializable {

    @Getter
    List<Person> passengerList;

    @Getter
    @Setter
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
    private String cardHolderName;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String expirationDate;

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

    public String toStartAndClear() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String toFormContactAndClear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("SessionBean1");
        return "/partials/formContact.xhtml?faces-redirect=true&amp;includeViewParams=true";
    }
 
}
