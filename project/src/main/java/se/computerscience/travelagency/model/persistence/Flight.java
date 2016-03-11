package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Flight implements Serializable{

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
    @Setter
    //@Column(nullable = false)
    private Plane plane;
    
    @ManyToOne
    @Getter
    @Setter
    //@Column(nullable = false)
    private City depCity;
    
    @ManyToOne
    @Getter
    @Setter
    //@Column(nullable = false)
    private City desCity;
    
    @OneToMany(mappedBy = "flyTo")
    @JoinColumn(name = "id")
    private List<Booking> bookingFlyToList;
    
    @OneToMany(mappedBy = "flyBack")
    @JoinColumn(name = "id")
    private List<Booking> bookingFlyBackList;
    
    public static class Comparators {

        public static Comparator<Flight> PRICE = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return (int) (f1.price - f2.price);
            }
        };
        public static Comparator<Flight> FLIGHT_TIME = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                Date f1D = f1.depature;
                Date f1A = f1.arrival;
                Date f2D = f2.depature;
                Date f2A = f2.arrival;
                return (int) ((f1A.getTime() - f1D.getTime()) - (f2A.getTime() - f2D.getTime()));
            }
        };
        public static Comparator<Flight> PRICEandTIME = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                int i = Comparators.PRICE.compare(f1, f2);
                if (i == 0) {
                    i = Comparators.FLIGHT_TIME.compare(f1, f2);
                }
                return i ;
            }
        };
        
        
    }
    
}
