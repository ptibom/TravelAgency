package utilities.validators;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("postalCode")
public class ValidatorPostalCode implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        ValidatorUtility.updateField(context, "postalCode");
         String postalCode = (String)value;
       if(postalCode == null){ ValidatorUtility.sendMessage("Input is empty");}
    }
}