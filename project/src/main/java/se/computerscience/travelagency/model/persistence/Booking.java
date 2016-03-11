package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @Column(nullable = false)
    private Double price;
   
    @OneToMany(mappedBy = "person")
    private List<Person> person;
    
    @ManyToOne
    private Flight flyTo;
    
    @ManyToOne
    private Flight flyBack;
    
    @ManyToOne
    private Hotel hotel;
    
    @ManyToOne
    private City desCity;
    
    @ManyToOne
    private City depCity;
}
