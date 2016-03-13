package utilities.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailAddress")
public class ValidatorEmailAddress implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        ValidatorUtility.updateField(context, "emailAddress");
        String emailAddress = (String) value;
        if (emailAddress == null) {
            ValidatorUtility.sendMessage("Input is empty");
        } else {
            if (!emailAddress.contains("@")) {
                ValidatorUtility.sendMessage("Not a valid email address"); 
            }
        }
    }
}
