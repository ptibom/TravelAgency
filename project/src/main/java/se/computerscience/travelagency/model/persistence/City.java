package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;
    
    @OneToMany(mappedBy = "depCity")
    private List<Flight> flightDepList;
    
    @OneToMany(mappedBy = "desCity")
    private List<Flight> flightDesList;
    
    @OneToMany(mappedBy = "depCity")
    private List<Booking> bookingDepList;
    
    @OneToMany(mappedBy = "desCity")
    private List<Booking> bookingDesList;
}
