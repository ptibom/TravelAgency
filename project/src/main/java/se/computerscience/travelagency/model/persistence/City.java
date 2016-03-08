package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @Getter
    private List<Hotel> hotelList;
    
    @OneToMany(mappedBy = "depCity")
    @Getter
    @JoinColumn(name = "id")
    private List<Flight> flightDepList;
    
    @OneToMany(mappedBy = "desCity")
    @Getter
    @JoinColumn(name = "id")
    private List<Flight> flightDesList;
    
    @OneToMany(mappedBy = "depCity")
    @JoinColumn(name = "id")
    private List<Booking> bookingDepList;
    
    @OneToMany(mappedBy = "desCity")
    @JoinColumn(name = "id")
    private List<Booking> bookingDesList;
}
