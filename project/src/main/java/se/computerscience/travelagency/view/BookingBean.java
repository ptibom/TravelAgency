/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import se.computerscience.travelagency.model.persistence.IBookingDAO;
import se.computerscience.travelagency.model.persistence.Person;

@Named(value = "bookingBean")
@ManagedBean
@SessionScoped
public class BookingBean {

    @Getter
    @Setter
    @NotNull
    String creditCardNumber;

    @Getter
    @Setter
    @NotNull
    String cardHolderName;

    @Getter
    @Setter
    @NotNull
    String expirationDate;

    @Getter
    @Setter
    @NotNull
    String cardOption;

    public void validateCreditCard(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();
        UIComponent comps = event.getComponent();

        // Ui input
        UIInput uiInputCreditCardNr = (UIInput) comps.findComponent("creditCardNumber");
        UIInput uiInputcardHolderName = (UIInput) comps.findComponent("cardHolderName");
        UIInput uiInputexpirationDate = (UIInput) comps.findComponent("creditCardNumber");;
        UIInput uiInputCardOption = (UIInput) comps.findComponent("cardOption");;

        String creditCardNr = uiInputCreditCardNr.getLocalValue() == null ? ""
                : uiInputCreditCardNr.getLocalValue().toString();
        String cardHolderNam = uiInputcardHolderName.getLocalValue() == null ? ""
                : uiInputcardHolderName.getLocalValue().toString();
        String expirationDat = uiInputexpirationDate.getLocalValue() == null ? ""
                : uiInputexpirationDate.getLocalValue().toString();
        String cardOpt = uiInputCardOption.getLocalValue() == null ? ""
                : uiInputCardOption.getLocalValue().toString();
        
        // If any of them are empty, let the ordinary validators handle them
        if (cardOpt.isEmpty() || expirationDat.isEmpty() ||
                 cardHolderNam.isEmpty() ||creditCardNr.isEmpty()) {
		return;
	  }
        
        boolean valid = true;
        String VALIDATE_ERROR_MESSAGE = "";

        //Get parameters
        String creditCardNrID = uiInputCreditCardNr.getClientId();

        switch (cardOpt) {

            case "0":
                valid = validateMasterCard(creditCardNr);
                VALIDATE_ERROR_MESSAGE = "MasterCard number not valid";
                break;
            case "1":
                valid = validateVisa(creditCardNr);
                VALIDATE_ERROR_MESSAGE = "Visa number not valid";
                break;
            case "2":
                valid = validateAmericanExpress(creditCardNr);
                VALIDATE_ERROR_MESSAGE = "American Express number not valid";
                break;
            default:
        }

        if (!valid) {
            FacesMessage msg = new FacesMessage(VALIDATE_ERROR_MESSAGE);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(creditCardNrID, msg);
            fc.renderResponse();
        }
    }

    @PostConstruct
    public void init(){
        cardOption = "0";
    }
    private boolean validateMasterCard(String value) {

        return value.length() == 16 && value.substring(0, 1).equals("5");
    }

    private boolean validateAmericanExpress(String value) {

        return value.length() == 15 && value.substring(0, 1).equals("3");
    }

    private boolean validateVisa(String value) {

        System.out.println("Visa card length:" + value.length() + " FIRST VALUE=" +  value.substring(0, 1) );
        return value.length() == 16 && value.substring(0, 1).equals("4");
    }

}
