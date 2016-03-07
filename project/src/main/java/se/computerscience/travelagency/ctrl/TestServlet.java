/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.computerscience.travelagency.model.persistence.City;
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.ICityDAO;
import se.computerscience.travelagency.model.persistence.IDAO;
import se.computerscience.travelagency.model.persistence.IFlightDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.model.persistence.Plane;
import utilities.Entities;

/**
 *
 * @author Hossein
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet/"})
public class TestServlet extends HttpServlet {

    /*@EJB
    private IDAO<Object> testDAO;
    */
    @EJB
    private IFlightDAO flightDAO;
    
    @EJB
    private ICityDAO cityDAO;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        City city = new City();
        city.setName("test");
        cityDAO.create(city);
        
        /*for(City c: cityDAO.findAll()){
            System.out.println("CityName"+ c.getName());
        }*/
        
        for(City c: cityDAO.searchCityByName("b")){
            System.out.println("CityName "+ c.getName());
        }
        
        /*for(City c: cityDAO.searchCityByName("%b%")){
            System.out.println("CityName "+ c.getName());
        }*/
        
        //searchFlight("gbg");
        //searchFlight("najaf");
        
        /*int i = 0;
        City cityById  = (City) flightDAO.findById(1L, Entities.city);
        if(cityById != null) {
            
            System.out.println("Find flight for city test");
            System.out.println("This is found by id "+ cityById.getName() + "\n");
            System.out.println("The value of city-: "+cityById.toString() + " " +cityById.getFlightDepList());
            for(Flight fly : cityById.getFlightDepList()) {
                System.out.println("Loop #"+i + " id for this is: "+fly.getId());
                i++;
            }
        }*/
        
        
        //for(Flight fly : flightDAO.getByName(name))       
        /*Person person = new Person();
        person.setFirstName("TEST Abdi");
        person.setLastName("ololololo");
        Long id = 1L;
        
        Plane plane = new Plane();
        plane.setCapacity(10);
        plane.setType("TheGoodType");
        
        testDAO.create(person);
        testDAO.create(plane);
        
        testDAO.delete(0L, Entities.person);
        
        City cityById  = (City) testDAO.findById(1L, Entities.city);
        if(cityById != null) {
            System.out.println("This is found by id "+ cityById.getName() + "\n");
        }
        
        List<Person> pl = (List<Person>)(List<?>)testDAO.findAll(Entities.person);
        
        for(Person pers : pl){
            System.out.println(pers.getFirstName()+" "+ pers.getLastName());
        }
        
        List<Flight> flights = (List<Flight>)(List<?>) testDAO.findAll(Entities.flight);
        
        for(Flight fly : flights) {
            System.out.println("The Price of the flight " + fly.getPrice());
        }
        
        List<City> citys = (List<City>)(List<?>) testDAO.findAll(Entities.city);
        for(City city : citys) {
            System.out.println("The name of the citys" + city.getName());
        }*/
    }
    
    
    /*public void searchFlight(String desCity){
        int i = 0;
        City testCity = cityDAO.findById(0L, Entities.city);
        if (testCity != null && desCity != null) {
            for(Flight fly : testCity.getFlightDepList()) {
                if (desCity.equals(((City)fly.getDesCity()).getName())) {
                    System.out.println("Loop #"+i + " FlightId: "+fly.getId());
                }
                i++;
            }
        }else {
            System.out.println("FAIL");
        }
        i = 0;
    }*/
    

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
