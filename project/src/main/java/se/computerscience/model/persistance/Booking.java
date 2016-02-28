/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.model.persistance;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Getter
    @Setter
    @Column(nullable = false, name = "PRICE")
    private Double price;
   
    @ManyToOne
    private Person person;
    
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
