package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.TemporalType;
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
    //@Column(nullable = false)
    private Double price;
   
   @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PERSON_BOOKING", joinColumns=@JoinColumn(name="BOOKING_ID", referencedColumnName ="ID"),
            inverseJoinColumns=@JoinColumn(name="PERSON_ID", referencedColumnName="ID"))
    @Setter
    @Getter
    //@Column(nullable = false)
    private List<Person> person;

    
    @ManyToOne
    @Setter
    @Getter
    //@Column(nullable = false)
    private Flight flyTo;
    
    @ManyToOne
    @Setter
    @Getter
    //@Column(nullable = false)
    private Flight flyBack;
    
    @ManyToOne
    @Getter
    @Setter
    //@Column(nullable = false)
    private Hotel hotel;
    
    @ManyToOne
    @Getter
    @Setter
    //@Column(nullable = false)
    private City desCity;
    
    @ManyToOne
    @Setter
    @Getter
    //@Column(nullable = false)
    private City depCity;
    
    @Getter
    @Setter
    //@Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyToDate;
    
    @Getter
    @Setter
    //@Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyBackDate;
}
