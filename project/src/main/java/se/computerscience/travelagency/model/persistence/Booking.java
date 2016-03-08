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
    @Column(nullable = false)
    private Person person;
    
    @ManyToOne
    @Getter
    @Column(nullable = false)
    private Flight flyTo;
    
    @ManyToOne
    @Getter
    @Column(nullable = false)
    private Flight flyBack;
    
    @ManyToOne
    @Getter
    @Column(nullable = false)
    private Hotel hotel;
    
    @ManyToOne
    @Getter
    @Column(nullable = false)
    private City desCity;
    
    @ManyToOne
    @Getter
    @Column(nullable = false)
    private City depCity;
    
    @Getter
    @Setter
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyToDate;
    
    @Getter
    @Setter
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date flyBackDate;
}
