package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(nullable = false)
    private Double price;
   
    @ManyToOne
    @Getter
    private Person person;
    
    @ManyToOne
    @Getter
    private Flight flyTo;
    
    @ManyToOne
    @Getter
    private Flight flyBack;
    
    @ManyToOne
    @Getter
    private Hotel hotel;
    
    @ManyToOne
    @Getter
    private City desCity;
    
    @ManyToOne
    @Getter
    private City depCity;
    
    @Getter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyToDate;
    
    @Getter
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyBackDate;
}
