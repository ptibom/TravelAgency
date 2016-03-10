package se.computerscience.travelagency.ctrl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.computerscience.travelagency.model.persistence.City;
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
        
        
        List<Hotel> hList = hotelDAO.findAll();
        hotelDAO.orderByPrice(hList);
        for(Hotel hotel: hList) {
            System.out.println("Price: "+hotel.getPrice());
        }
        
        hotelDAO.orderByRating(hList);
        for(Hotel hotel: hList) {
            System.out.println("rating: "+hotel.getRating());
        }
        
        hotelDAO.orderByName(hList);
        for(Hotel hotel: hList) {
            System.out.println("name: "+hotel.getName());
        }
        
        hotelDAO.orderByRatingAndPrice(hList);
        for(Hotel hotel: hList) {
            System.out.println("price: "+hotel.getPrice() + " rating: "+hotel.getRating());
        }
        
        
        /*City city = cityDAO.findById(101L);
        Calendar cal = new GregorianCalendar();
        cal.set(2016, 02, 01);
        Date d1 = cal.getTime();
        
        cal.set(2016, 05, 01);
        Date d2 = cal.getTime();
        int counter = 0;
        
        List<Hotel> availableHotel = new LinkedList<>();
        if (city != null) {
            System.out.println("C id "+city.getId());
            List<Hotel> hotelList = city.getHotelList();
            System.out.println("Size of hotelList" + hotelList.size());
            for (Hotel hotel : hotelList) {
                counter = hotelDAO.searchByDate(d1, d2, hotel).size();
                if ((hotel.getNumberOfRooms() - counter) >= 1) {
                    availableHotel.add(hotel);
                }
            }
            for (Hotel hotel : availableHotel) {
                System.out.println("available hotel "+hotel.getName());
            }
        }*/
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
