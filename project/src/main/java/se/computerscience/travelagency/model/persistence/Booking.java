package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
   
    @Setter
    @Getter
    @ManyToMany
    @JoinTable(name="PERSON_BOOKING", joinColumns=@JoinColumn(name="BOOKING_ID", referencedColumnName ="ID"),
               inverseJoinColumns=@JoinColumn(name="PERSON_ID", referencedColumnName="ID"))
    private List<Person> persons;

    
    
    @Setter
    @Getter
    @ManyToOne
    private Flight flyTo;
    
    @Setter
    @Getter
    @ManyToOne
    private Flight flyBack;
    
    @Getter
    @Setter
    @ManyToOne
    private Hotel hotel;
    
    @Getter
    @Setter
    @ManyToOne
    private City desCity;
    
    @Setter
    @Getter
    @ManyToOne
    private City depCity;
    
    @Getter
    @Setter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyToDate;
    
    @Getter
    @Setter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyBackDate;
    
    public long getPersonId() {
        return persons.get(0).getId();
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", price=" + price + ", persons=" + persons + ", flyTo=" + flyTo + ", flyBack=" + flyBack + ", hotel=" + hotel + ", desCity=" + desCity + ", depCity=" + depCity + ", flyToDate=" + flyToDate + ", flyBackDate=" + flyBackDate + '}';
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
    
    public long getDesCityId() {
        return desCity.getId();
    }
    
    public long getDepCityId() {
        return depCity.getId();
    }
    
    public long getFlyToId() {
        return flyTo.getId();
    }
    
    public long getFlyBackId() {
        return flyBack.getId();
    }
    
    public long getHotelId() {
        return hotel.getId();
    }
}
