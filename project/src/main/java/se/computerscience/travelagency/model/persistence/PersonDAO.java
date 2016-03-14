package se.computerscience.travelagency.model.persistence;

import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class PersonDAO extends GeneralDAO<Person> implements IPersonDAO {
    
    public PersonDAO() {
        super(Person.class);
    }
    
}
