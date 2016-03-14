package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date depature; 
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrival;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private Double price;
    
    @ManyToOne
    @Setter
    private Plane plane;
    
    @ManyToOne
    @Getter
    @Setter
    private City depCity;
    
    @ManyToOne
    @Getter
    @Setter
    private City desCity;
    
    @OneToMany(mappedBy = "flyTo")
    @JoinColumn(name = "id")
    private List<Booking> bookingFlyToList;
    
    @OneToMany(mappedBy = "flyBack")
    @JoinColumn(name = "id")
    private List<Booking> bookingFlyBackList;
    
    public String getDuration(){
        String time = "";
        long duration  = depature.getTime() - arrival.getTime();
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(duration);

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        
        if (hours != 0) {
            time += hours+" h ";
        } 
        if (minutes != 0){
            time += minutes+" m";
        }
        return time;
    }
    
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
        
        public static Comparator<Flight> EARLIEST = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return f1.depature.compareTo(f2.depature);
            }
        };
        
        public static Comparator<Flight> LATEST = new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                return f2.depature.compareTo(f1.depature);
            }
        };
        
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", depature=" + depature + ", arrival=" + arrival + ", price=" + price + ", plane=" + plane + ", depCity=" + depCity + ", desCity=" + desCity + ", bookingFlyToList=" + bookingFlyToList + ", bookingFlyBackList=" + bookingFlyBackList + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    
}
