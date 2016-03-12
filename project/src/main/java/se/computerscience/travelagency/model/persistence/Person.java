package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.PERSIST;
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
  //  @JoinTable(name = "PERSON_BOOKING")
    private List<Booking> bookingList;
    
    public Person() {
    }
    
    public void AddBooking(Booking b){
        if(bookingList == null)bookingList = new ArrayList<Booking>();
        bookingList.add(b);
    }
     
}
