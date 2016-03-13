
package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
public class Hotel implements Serializable, Comparable<Hotel>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private int numberOfRooms;
    
    @Getter
    @Setter
    @Max(value = 10)
    @Min(value = 0)
    @Column(nullable = false)
    private int rating;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String name;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String decsription;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private int price;
    
    @ManyToOne
    @Setter
    @Getter
    private City city;
        
    @OneToMany(mappedBy = "hotel")
    @JoinColumn(name = "id")
    @Getter
    private List<Booking> bookingList;

    @Override
    public int compareTo(Hotel hotel) {
        return Comparators.NAME.compare(this, hotel);
    }
    
    public Long getCityId(){
        return city.getId();
    }
    
    
    public static class Comparators {

        public static Comparator<Hotel> NAME = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return h1.name.compareTo(h2.name);
            }
        };
        
        public static Comparator<Hotel> RATING = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return h2.getRating() - h1.getRating();
            }
        };
        
        public static Comparator<Hotel> PRICE = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return h1.getPrice()-(h2.getPrice());
            }
        };
        
        public static Comparator<Hotel> RATINGandPRICE = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                int i = Comparators.RATING.compare(h1, h2);
                if (i == 0) {
                    i = Comparators.PRICE.compare(h1, h2);
                }
                return i;
            }
        };
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", numberOfRooms=" + numberOfRooms + ", rating=" + rating + ", name=" + name + ", decsription=" + decsription + ", price=" + price + ", city=" + city + ", bookingList=" + bookingList + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    
}
