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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Hossein
 */
@Entity
public class Person implements Serializable {   
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "{required.field}")
    @Getter
    private Long id;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Column(nullable = false)
    private String gender;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp="[A-Za-zÅÄÖåäö]+")
    @Size(max = 255)
    @Column(nullable = false)
    private String firstName;
    
    @Getter
    @Setter
    @Pattern(regexp="[A-Za-zÅÄÖåäö]+")
    @NotNull(message = "{required.field}")
    @Size(max = 255)
    @Column(nullable = false)
    private String lastName;
   
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Size(max = 255)
    @Column(nullable = false)
    private String address;
    
     
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @Size(max = 255)
    @Column(nullable = false)
    private String postalCode;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @Size(max = 255)
    @Column(nullable = false)
    private String phoneNumber;   
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "{required.email}")
    @NotNull(message = "{required.field}")
    @Size(max = 255)
    @Column(nullable = false)
    private String emailAdress;
    
    @ManyToMany(mappedBy = "person")
    private List<Booking> bookings;
    
    public Person() {
    }
    
    public void addBooking (Booking b){
        if (bookings == null) { 
            bookings = new ArrayList<>();
        }
        bookings.add(b);
    }
     
}
