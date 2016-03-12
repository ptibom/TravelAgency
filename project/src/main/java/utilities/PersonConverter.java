package org.omnifaces.showcase.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import se.computerscience.travelagency.model.persistence.Person;

@FacesConverter("testConverter")
public class PersonConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        List<Person> passengers = new ArrayList<>();

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
            param += passenger.toString() + "|";
        }
        return param;
    }

}
