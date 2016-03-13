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
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.view.BookingBean;
import se.computerscience.travelagency.view.SearchBean;


public class BookingCtrl {
    
    public void save() {}
    public List<Person> getPassengers(String query) {return null;}
/*
   
    @EJB
    IBookingDAO bookingDAO;

    @EJB
    IHotelDAO hotelDAO;

    @EJB
    ICityDAO cityDAO;

    @EJB
    IFlightDAO flightDAO;

    @Inject
    BookingBean bookingBean;
    @Inject
    SearchBean searchBean;

    public void save() {
        Booking booked = new Booking();
        booked.setFlyBackDate(searchBean.getFromDate());
        booked.setFlyToDate(searchBean.getToDate());
        booked.setPrice(1000.0);
        booked.setDepCity(cityDAO.findById(1L));
        booked.setDesCity(cityDAO.findById(2L));
        booked.setFlyBack(flightDAO.findById(1L));
        booked.setFlyTo(flightDAO.findById(2L));
        booked.setHotel(hotelDAO.findById(1L));
        for (Person passenger : bookingBean.getPassengerList()) {
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
*/
}
