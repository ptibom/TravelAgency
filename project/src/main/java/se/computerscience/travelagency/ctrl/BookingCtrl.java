/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.view.BookingBean;
import se.computerscience.travelagency.view.SearchBean;



   @Model
   @ManagedBean
   @SessionScoped
   public class BookingCtrl{
    
    @EJB
    IBookingDAO bookingDAO;

    @Inject
     BookingBean bookingBean;
    @Inject
     SearchBean searchBean;
    
    public void save(){     
    Booking booked = new Booking();
    booked.setFlyBackDate(searchBean.getFromDate());
    booked.setFlyToDate(searchBean.getToDate());
    booked.setPrice(1000.0);
    
    // Create relationship
    booked.setPerson(bookingBean.getPassengerList());
    for(Person passenger : bookingBean.getPassengerList()){
       passenger.AddBooking(booked);
    } 
     bookingDAO.insertBooking(booked);
    }
    
    @Inject
    public void setBookingBean(BookingBean bookingBean) {
        this.bookingBean = bookingBean;
    }
    
    @Inject
    public void setSearchBean(SearchBean searchBean) {
        this.searchBean = searchBean;
    }
    
    public List<Person> getPassengers(String query) {
        return bookingDAO.getPassengers();
    }
    
    
}
    
    
   
