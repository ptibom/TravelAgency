package utilities.validators;


import com.sun.faces.facelets.component.UIRepeat;
import javax.faces.application.FacesMessage;
import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

final public class ValidatorUtility {

    private ValidatorUtility() {
    }
   
    // We need to update the field for each ui repeat
    public static void updateField(FacesContext context, String uiRepeatClientId) {
        context.getViewRoot().invokeOnComponent(context, uiRepeatClientId, new ContextCallback() {
            @Override
            public void invokeContextCallback(FacesContext context, UIComponent target) {
                UIRepeat uiRepeat = (UIRepeat) target;
                uiRepeat.processUpdates(context);
            }
        });
    }
    public static void sendMessage(String faceMsg){
             FacesMessage msg = new FacesMessage(faceMsg);
             msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(msg);
}
}