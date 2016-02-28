/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.model.persistance;

import java.io.Serializable;
import java.util.List;
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
public class Person implements Serializable {
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
    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false, name = "LST_NAME")
    private String lastName;
   
    @OneToMany(mappedBy = "Booking")
    private List<Booking> bookingList;
    
}
