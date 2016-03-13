package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @JoinColumn(name = "id")
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
    @Getter
    private List<Booking> bookingDepList;
    
    @OneToMany(mappedBy = "desCity")
    @JoinColumn(name = "id")
    @Getter
    private List<Booking> bookingDesList;

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", hotelList=" + hotelList + ", flightDepList=" + flightDepList + ", flightDesList=" + flightDesList + ", bookingDepList=" + bookingDepList + ", bookingDesList=" + bookingDesList + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
