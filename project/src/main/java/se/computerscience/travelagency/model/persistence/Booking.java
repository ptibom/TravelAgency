package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    @Getter
    @Setter
    private int price;
   
    @ManyToOne
    @Getter
    @Setter
    private Person person;
    
    @ManyToOne
    @Getter
    @Setter
    private Flight flyTo;
    
    @ManyToOne
    @Getter
    @Setter
    private Flight flyBack;
    
    @ManyToOne
    @Getter
    @Setter
    private Hotel hotel;
    
    @ManyToOne
    @Getter
    @Setter
    private City desCity;
    
    @ManyToOne
    @Getter
    @Setter
    private City depCity;
    
    @Getter
    @Setter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyToDate;
    
    @Getter
    @Setter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyBackDate;
    
    public long getDesCityId() {
        return desCity.getId();
    }
    
    public long getDepCityId() {
        return depCity.getId();
    }
    
    public long getHotelId() {
        return hotel.getId();
    }
    
    public long getFlyToId() {
        return flyTo.getId();
    }
    
    public long getFlyBackId() {
        return flyBack.getId();
    }
    
    public long getPersonId() {
        return person.getId();
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", price=" + price + ", person=" + person + ", flyTo=" + flyTo + ", flyBack=" + flyBack + ", hotel=" + hotel + ", desCity=" + desCity + ", depCity=" + depCity + ", flyToDate=" + flyToDate + ", flyBackDate=" + flyBackDate + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
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
