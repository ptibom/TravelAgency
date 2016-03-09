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

/**
 *
 * @author Daniel
 */
@Named("hotels")
@ManagedBean
public class HotelsBB {
    
    @Setter
    @Getter
    List<Hotel> allHotels = new ArrayList<>();
    
     @PostConstruct
     private void init() {
         
        Hotel h1 = new Hotel();
        h1.setName("Matildas cryhouse hotel");
        h1.setPrice(5000.0);
        Hotel h2 = new Hotel();
        h2.setName("Joachims hönshus hotel");
        h2.setPrice(5000.0);
        Hotel h3 = new Hotel();
        h2.setName("Prasads enarmade hotel");
        h2.setPrice(5000.0);
        Hotel h4 = new Hotel();
        h2.setName("Johans fuskcircus hotel");
        h2.setPrice(5000.0);
        
        allHotels.add(h1);
        allHotels.add(h2);
        allHotels.add(h3);
        allHotels.add(h4);
         
    }
     
     public int getCount(){
         return allHotels.size();
     }
    
    
}
