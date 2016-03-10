package se.computerscience.travelagency.view;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
         Backing bean

         *** Nothing to do here ***
          
 * @author hajo
 */
@Named("selectOneButton")
@RequestScoped 
@ManagedBean
public class SelectOneButtonBB {

    @Setter
    @Getter
    private String option = "0";
    
    @PostConstruct
    private void init() {
        option = "0";
    }
 
    
    
}


