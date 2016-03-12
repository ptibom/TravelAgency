/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.view.BookingBean;
import se.computerscience.travelagency.view.SearchBean;



   @Named("bookingctrl")
   @SessionScoped
   public class BookingCtrl{
    
    @EJB
    IBookingDAO bookingDAO;
    
    
    
    
    private BookingBean bookingbean;
    private SearchBean searchbean;
    
    
    
    public void save(){
        
      System.out.println(" I was run");
    Booking booked = new Booking();
    booked.setFlyBackDate(searchbean.getFromDate());
    booked.setFlyToDate(searchbean.getToDate());
    booked.setPrice(1000.0);
    
    bookingDAO.insertBooking(searchbean.getPassengerList(), booked);
        
    
    }
    
    @Inject
    public void setAddBB(BookingBean bookingbean) {
        this.bookingbean = bookingbean;
    }
    
    public List<Person> getPassengers(String query) {
        return bookingDAO.getPassengers();
    }
    
    
}
    
    
   
