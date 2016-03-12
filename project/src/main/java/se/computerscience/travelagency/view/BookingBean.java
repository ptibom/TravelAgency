/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
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
    @Size(min=16, max=16)
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
    @NotNull(message = "{required.field}")
    private String cardOption;


    @PostConstruct
    public void init(){
        cardOption = "0";
    }
    
       public List<Person> intializePassengerList(){
           System.out.println(numPassengers);
        passengerList = new ArrayList<>();
        
        if(numPassengers == null)return null;
        int passangers = Integer.parseInt(numPassengers);
        
        for(int i = 0; i<passangers; i++){
            passengerList.add(new Person());
        }
        
        return passengerList;
        
    }
}
