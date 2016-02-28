package se.computerscience.model.persistance;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    
    @OneToMany(mappedBy = "hotel")
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
