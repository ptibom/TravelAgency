package se.computerscience.travelagency.ctrl;

import com.sun.grizzly.util.buf.TimeStamp;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.IHotelDAO;
/**
 *
 * @author Hossein
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet/"})
public class TestServlet extends HttpServlet {

    @EJB
    private IFlightDAO flightDAO;
    
    @EJB
    private ICityDAO cityDAO;
    
    @EJB
    private IHotelDAO hotelDAO;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* f1 = new Flight();
        Flight f2 = new Flight();
        Flight f3 = new Flight();
        
        Calendar cal = new GregorianCalendar();
        cal.set(2016, 8, 1, 5, 25);
        Date arrival = cal.getTime();

        flightDAO.create(f1);*/
        /*//**
        cal.set(2016, 8, 1, 5, 55);
        arrival = cal.getTime();
        f2.setArrival(arrival);
        
        cal.set(2016, 8, 1, 7, 5);
        dest = cal.getTime();
        f2.setArrival(dest);
        //**
        cal.set(2016, 8, 1, 1, 15);
        arrival = cal.getTime();
        f3.setArrival(arrival);
        
        cal.set(2016, 8, 1, 7, 5);
        dest = cal.getTime();
        f3.setArrival(dest);
        //**
        
        flightDAO.create(f1);
        flightDAO.create(f2);
        flightDAO.create(f3);*/
        
        // tests
        System.out.println("EARLIEST:");
        for(Flight fl: flightDAO.orderByEarliest(flightDAO.findAll())) {
            System.out.println(fl.getId()+" Duration: "+fl.getDuration());
        }
        System.out.println("LATEST:");
        for(Flight fl: flightDAO.orderByLatest(flightDAO.findAll())) {
            System.out.println("Duration: "+fl.getDuration());
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
