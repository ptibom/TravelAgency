/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Hossein
 */
public interface IHotelDAO extends IDAO<Hotel> {
    public List<Hotel> searchByDate(String from, String to, City city);
}

