package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private Long id;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private String gender;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String firstName;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String lastName;
   
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String address;
    
     
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String postalCode;
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String phoneNumber;   
    
    @Getter
    @Setter
    @Size(max = 255)
    @Column(nullable = false)
    private String emailAdress;
    
    @ManyToMany(mappedBy = "person")
    @JoinTable(name = "PERSONS")
    private List<Booking> bookingList;
    
    public Person() {
    }
    
    @Override
    public String toString(){
        return gender + ":" + firstName +":" + lastName +":" + address +":" + postalCode +":" + phoneNumber +":" + emailAdress;
    }
    
    public void initializeFromParam(String param){
           
        String[] items = param.split(":");
        
        gender= items[0];
        firstName= items[1];
        lastName= items[2];
        address= items[3];
        postalCode= items[4];
        phoneNumber= items[5];
        emailAdress= items[6];
        
    }
    
}
