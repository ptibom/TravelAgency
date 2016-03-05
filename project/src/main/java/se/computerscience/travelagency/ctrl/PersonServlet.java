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
import se.computerscience.travelagency.model.persistence.Flight;
import se.computerscience.travelagency.model.persistence.IDAO;
import se.computerscience.travelagency.model.persistence.Person;
import se.computerscience.travelagency.model.persistence.Plane;

/**
 *
 * @author Hossein
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/PersonServlet/"})
public class PersonServlet extends HttpServlet {

    @EJB
    private IDAO<Object> personDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Person person = new Person();
        person.setFirstName("TEST Abdi");
        person.setLastName("ololololo");
        Long id = 1L;
        
        Plane plane = new Plane();
        plane.setCapacity(10);
        plane.setType("TheGoodType");
        
        personDAO.create(person);
        personDAO.create(plane);
        Class cls = Person.class;
        List<Person> pl = personDAO.findAll();
        
        for(Person pers : pl){
            System.out.println(pers.getFirstName()+" "+ pers.getLastName());
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
