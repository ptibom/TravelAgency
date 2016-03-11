
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class MasterCardValidation implements Validator {
    
    public static final String FORMAT_INVALID_MESSAGE_ID = "Not a valid mastercard number";
            
    @Override
    public void validate(FacesContext context, UIComponent component, 
                         Object toValidate) {

        boolean valid;
        String value;
        
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }
        
        value = toValidate.toString();
       
        valid = validateCard(value);
        
        if ( !valid ) {
            FacesMessage errMsg =
                new FacesMessage(FORMAT_INVALID_MESSAGE_ID);
            FacesContext.getCurrentInstance().addMessage(null, errMsg);
            throw new ValidatorException(errMsg);
        }
    }
    
    private boolean validateCard(String value){
        return value.length() == 16 && value.substring(0,0).equals("5");
    }
    
}