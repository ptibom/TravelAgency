/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.ctrl;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;


import javax.inject.Inject;
import javax.inject.Named;
import se.computerscience.travelagency.model.persistence.Booking;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.view.PaymentBB;


@Named(value = "bookingCtrl")
@RequestScoped
public class BookingCtrl {
    /*
    
    public void save() {}
    public List<Person> getPassengers(String query) {return null;}
*/
   
    @EJB
    private IBookingDAO bookingDAO;

    @EJB
    private IHotelDAO hotelDAO;

    @EJB
    private ICityDAO cityDAO;

    @EJB
    private IFlightDAO flightDAO;

    @Inject
    private PaymentBB paymentBB;
    
    public void save() {
        Booking booked = new Booking();

        booked.setDepCity(cityDAO.cityByName(paymentBB.getFromCity()));
        booked.setDesCity(cityDAO.cityByName(paymentBB.getToCity()));
        booked.setFlyBack(flightDAO.findById(Long.parseLong(paymentBB.getReturnFlight())));
        booked.setFlyTo(flightDAO.findById(Long.parseLong(paymentBB.getOutFlight())));
        booked.setHotel(hotelDAO.findById(Long.parseLong(paymentBB.getHotelId())));
        booked.setFlyBackDate(paymentBB.getFromDate());
        booked.setFlyToDate(paymentBB.getToDate());
        
        for (Person passenger : paymentBB.getPassengerList()) {
            passenger.addBooking(booked);
        }
        bookingDAO.insertBooking(booked);
    }

    @Inject
    public void setBookingBean(PaymentBB paymentBB) {
        this.paymentBB = paymentBB;
    }
    
    public List<Person> getPassengers(String query) {
        return bookingDAO.getPassengers();
    }

}
