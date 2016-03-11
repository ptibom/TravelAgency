/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.Person;

/**
 *
 * @author MonoMan
 */
@Named (value = "bookingbean")
@ManagedBean
@SessionScoped
public class BookingBean {
    
    @EJB
    IBookingDAO bookingDAO;
    
    @Getter
    @Setter
    String creditCardNumber;
   
    @Getter
    @Setter
    String cardHolderName;
    
    @Getter
    @Setter
    String expirationDate;
    
    @Getter
    @Setter
    String cardOption;
    
    public List<Person> getPassengers(String query) {
        return bookingDAO.getPassengers();
    }
    
}
