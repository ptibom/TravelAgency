
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.RequestScoped;

import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.Person;

/**
 *
 * @author MonoMan
 */
@Named(value = "paymentBB")
@ViewScoped
public class PaymentBB implements Serializable {

    @Getter
    List<Person> passengerList;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    @Pattern(regexp = "\\d+")
    @Size(min = 16, max = 16)
    private String creditCardNumber;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String cardHolderName;

    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String expirationDate;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    private String toCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    private String fromCity;
     
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    private String outFlight;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    private String returnFlight;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.letters}")
    private String hotelId;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String fromDate;
    
    @Getter
    @Setter
    @NotNull(message = "{required.field}")
    private String toDate;
   

}
