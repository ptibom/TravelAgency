package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
public class Flight implements Serializable {

    public Flight() {
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date depature; 
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrival;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private Double price;
    
    @ManyToOne
    private Plane plane;
    
    @ManyToOne
    @Getter
    private City depCity;
    
    @ManyToOne
    @Getter
    private City desCity;
    
    @OneToMany(mappedBy = "flyTo")
    private List<Booking> bookingFlyToList;
    
    @OneToMany(mappedBy = "flyBack")
    private List<Booking> bookingFlyBackList;
    
}
