package utilities.validators;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("firstName")
public class ValidatorFirstName implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         ValidatorUtility.updateField(context, "firstName");
          String firstName = (String)value;
       if(firstName == null){ ValidatorUtility.sendMessage("Input is empty");System.out.println("RONG");}
    }
}