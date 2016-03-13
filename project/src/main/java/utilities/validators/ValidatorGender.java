package utilities.validators;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("gender")
public class ValidatorGender implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       ValidatorUtility.updateField(context, "gender");
       String gender = (String)value;
       if(gender == null) {ValidatorUtility.sendMessage("Input is empty");System.out.println("RONG");}
      
    }
}