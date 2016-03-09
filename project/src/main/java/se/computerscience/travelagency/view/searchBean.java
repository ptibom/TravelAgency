package se.computerscience.travelagency.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.validator.FacesValidator;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Philip
 */
@Named(value = "searchBean")
@ManagedBean
@FacesValidator
public class searchBean {
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String fromCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "[A-Za-zÅÄÖåäö]+", message = "{required.letters}")
    @NotNull(message = "{required.field}")
    private String toCity;
    
    @Getter
    @Setter
    @Pattern(regexp = "\\d+", message = "{required.numbers}")
    @NotNull(message = "{required.field}")
    private String numPassengers;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date fromDate;
    
    @Getter
    @Setter
    @Future
    @NotNull(message = "{required.field}")
    private Date toDate;      
    
    public List<String> search(String query) {
        List<String> searchList = new ArrayList<>();
        searchList.add("lol1");
        searchList.add("LOL2");
        searchList.add("Gothenburg");
        return searchList;
    }
    
}
