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
@ViewScoped
public class ContactBB implements Serializable {
  @Getter
    @Setter
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
    
    @Getter
    @Setter
    private String toCity;
    
    @Getter
    @Setter
    private String hotelId;
    
    @Getter
    @Setter
    private String fromCity;
    
    @Getter
    @Setter
    private String flyTo;
     
    @Getter
    @Setter
    private String outFlight;
    
    @Getter
    @Setter
    private String returnFlight;
    
    @Getter
    @Setter
    @Future
    private Date  fromDate;
    
    @Getter
    @Setter
    @Future
    private Date  toDate;
   
    
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
}
