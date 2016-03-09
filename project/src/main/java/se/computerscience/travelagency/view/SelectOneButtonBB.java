
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
public class SelectOneButtonBB {

    
    
    @Setter
    @Getter
    private int option = 0;
    
    @PostConstruct
    private void init() {
        option = 1;
    }
 
}


