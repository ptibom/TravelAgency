package se.computerscience.travelagency.ctrl;

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
        
        
        List<Flight> fl = new LinkedList<>();
        Flight f1= new Flight();
        Flight f2= new Flight();
        Flight f3= new Flight();
       
        Calendar cal = new GregorianCalendar();
        cal.set(2016, 02, 3, 10, 55, 20);
        Date arrival = cal.getTime();        
        cal.set(2016, 02, 3, 8, 55, 20);
        Date depature = cal.getTime();
        // f1
        f1.setArrival(arrival);
        f1.setDepature(depature);
        f1.setDepCity(null);
        f1.setDesCity(null);
        f1.setPlane(null);
        f1.setPrice(100D);
        
        cal.set(2016, 02, 3, 10, 14, 20);
        arrival = cal.getTime();        
        cal.set(2016, 02, 3, 9, 55, 20);
        depature = cal.getTime();
        
        // f2
        f2.setArrival(arrival);
        f2.setDepature(depature);
        f2.setDepCity(null);
        f2.setDesCity(null);
        f2.setPlane(null);
        f2.setPrice(200D);

        cal.set(2016, 02, 3, 10, 15, 20);
        arrival = cal.getTime();        
        cal.set(2016, 02, 3, 9, 55, 20);
        depature = cal.getTime();
        
        // f3
        f3.setArrival(arrival);
        f3.setDepature(depature);
        f3.setDepCity(null);
        f3.setDesCity(null);
        f3.setPlane(null);
        f3.setPrice(150D);
        
        fl.add(f1);
        fl.add(f2);
        fl.add(f3);

        
        for (Flight flight : flightDAO.orderByDuration(fl)) {
            long duration  = (flight.getArrival().getTime() - flight.getDepature().getTime());
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            System.out.println("flight id "+flight.getId() + " duration " + diffInMinutes);
        }
        for (Flight flight : flightDAO.orderByPrice(fl)) {
            System.out.println("flight id "+flight.getId() + " price " + flight.getPrice());
        }
        for (Flight flight : flightDAO.orderByPriceAndDuration(fl)) {
            long duration  = (flight.getArrival().getTime() - flight.getDepature().getTime());
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            System.out.println("flight id "+flight.getId() + " duration " + diffInMinutes + " price " + flight.getPrice());
        }
        /*Calendar cal = new GregorianCalendar();
        cal.set(2016, 02, 24);
        cal.set(2016, 02, 3, 10, 55, 20);
        Date d1 = cal.getTime();
        cal.set(2016, 02, 3, 9, 5, 20);
        Date d2 = cal.getTime();
        Date startDate = d1;
        Date endDate   = d1;

        long duration  = d1.getTime() - d2.getTime();
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

        System.out.println("diff in sec" + diffInSeconds);
        System.out.println("diff in min" + diffInMinutes);
        System.out.println("diff in hour" + diffInHours);*/
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
