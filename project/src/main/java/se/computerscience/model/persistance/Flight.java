/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.model.persistance;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hossein
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false, name = "DEPATURE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date depature; // sql or util ?
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false, name = "ARRIVAL")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrival; // sql or util ?
    
    @Getter
    @Setter
    @Column(nullable = false, name = "PRICE")
    private Double price;
    
    @ManyToOne
    private Plane plane;
    
    @ManyToOne
    private City depCity;
    
    @ManyToOne
    private City desCity;
    
    @OneToMany(mappedBy = "Booking")
    private List<Booking> bookingFlyToList;
    
    @OneToMany(mappedBy = "Booking")
    private List<Booking> bookingFlyBackList;
    
}
