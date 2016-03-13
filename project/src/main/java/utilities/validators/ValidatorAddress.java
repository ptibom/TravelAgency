package utilities.validators;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("address")
public class ValidatorAddress implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       ValidatorUtility.updateField(context, "address");
       String address = (String)value;
       if(address == null){ ValidatorUtility.sendMessage("Input is empty");}
      
    }
}