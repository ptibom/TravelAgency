/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Hotel;
import se.computerscience.travelagency.model.persistence.hotelTemporary;

/**
 *
 * @author Daniel
 */
@ManagedBean(name= "hotels")
public class HotelsBB {
    
    @Setter
    @Getter
    List<hotelTemporary> allHotels = new ArrayList<>();
    
     @PostConstruct
     private void init() {
         
        hotelTemporary h1 = new hotelTemporary();
        h1.setName("Matildas cryhouse hotel");
        h1.setPrice(5000.0);
        hotelTemporary h2 = new hotelTemporary();
        h2.setName("Joachims hönshus hotel");
        h2.setPrice(5000.0);
        hotelTemporary h3 = new hotelTemporary();
        h3.setName("Prasads enarmade hotel");
        h3.setPrice(5000.0);
        hotelTemporary h4 = new hotelTemporary();
        h4.setName("Johans fuskcircus hotel");
        h4.setPrice(5000.0);
        
        allHotels.add(h1);
        allHotels.add(h2);
        allHotels.add(h3);
        allHotels.add(h4);
         
    }
     
     public int getCount(){
         return allHotels.size();
     }

    
     
    
}


