package utilities.validators;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneNumber")
public class ValidatorPhoneNumber implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        ValidatorUtility.updateField(context, "phoneNumber");
         String phoneNumber = (String)value;
       if(phoneNumber == null){ ValidatorUtility.sendMessage("Input is empty");}
    }
}