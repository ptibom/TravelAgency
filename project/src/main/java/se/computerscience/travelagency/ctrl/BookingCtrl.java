/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.ctrl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.view.ContactBB;
import se.computerscience.travelagency.view.PaymentBB;


@Named(value = "bookingCtrl")
@SessionScoped
public class BookingCtrl implements Serializable{
   
    @EJB
    private IBookingDAO bookingDAO;

    @EJB
    private IHotelDAO hotelDAO;

    @EJB
    private ICityDAO cityDAO;

    @EJB
    private IFlightDAO flightDAO;

    private ContactBB contactBB;
    
    public void save() {
        Booking booked = new Booking();
        Date fromDate;
        Date toDate;
        try {
            fromDate = SimpleDateFormat.getDateInstance().parse(contactBB.getFromDate());
            toDate = SimpleDateFormat.getDateInstance().parse(contactBB.getToDate());
        }
        catch (Exception e) {
            return;
        }
                
        booked.setDepCity(cityDAO.cityByName(contactBB.getFromCity()));
        booked.setDesCity(cityDAO.cityByName(contactBB.getToCity()));
        booked.setFlyBack(flightDAO.findById(Long.parseLong(contactBB.getReturnFlight())));
        booked.setFlyTo(flightDAO.findById(Long.parseLong(contactBB.getOutFlight())));
        booked.setHotel(hotelDAO.findById(Long.parseLong(contactBB.getHotelId())));
        booked.setFlyBackDate(fromDate);
        booked.setFlyToDate(toDate);
       
        booked.setPerson(contactBB.getPassengerList());
        for (Person passenger : contactBB.getPassengerList()) {
            passenger.addBooking(booked);
        } 
        bookingDAO.insertBooking(booked);  
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

     @Inject
    public void setContactBB(ContactBB contactBB) {
        this.contactBB = contactBB;
    }
    
    public List<Person> getPassengers(String query) {
        return bookingDAO.getPassengers();
    }
}
