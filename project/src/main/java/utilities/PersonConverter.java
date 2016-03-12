package utilities;


import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import se.computerscience.travelagency.model.persistence.Person;

@FacesConverter("personConverter")
public class PersonConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        List<Person> passengers = new ArrayList<>();
        
        if(passengers.isEmpty())throw new ConverterException("No passengers found");

        //Return string to List of objects, splitting person by |
        for (String person : value.split("|")) {
            Person p = new Person();
            p.initializeFromParam(person);
            passengers.add(p);
        }

        return passengers;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String param = "";
        List<Person> passengers = (ArrayList<Person>) value;

        for (Person passenger : passengers) {
            param += passenger.toViewParamString() + "|";
        }
        return param;
    }

}
