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
public class Plane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String type;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private Integer capacity;
    
    @OneToMany(mappedBy = "plane")
    @JoinColumn(name = "id")
    @Getter
    private List<Flight> flightList;

   
    public Plane(String type, Integer capacity, List<Flight> flightList) {
        this.type = type;
        this.capacity = capacity;
        this.flightList = flightList;
    }

    public Plane() {
    }

    @Override
    public String toString() {
        return "Plane{" + "id=" + id + ", type=" + type + ", capacity=" + capacity + ", flightList=" + flightList + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane other = (Plane) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    
}
