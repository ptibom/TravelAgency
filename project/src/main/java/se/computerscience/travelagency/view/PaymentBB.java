
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
    private String toCity;
    
    @Getter
    @Setter
    private String fromCity;
    
    @Getter
    @Setter
    private String flyTo;
     
    @Getter
    @Setter
    private String outFlight;
    
    @Getter
    @Setter
    private String returnFlight;
    
    @Getter
    @Setter
    private String hotelId;
    
    @Getter
    @Setter
    @Future
    private Date  fromDate;
    
    @Getter
    @Setter
    @Future
    private Date  toDate;
   
    
    public PaymentBB() {
    }
        public String toStartAndClear() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String toFormContactAndClear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("SessionBean1");
        return "/partials/booking/formContact.xhtml?faces-redirect=true&amp;includeViewParams=true";
    }
}
