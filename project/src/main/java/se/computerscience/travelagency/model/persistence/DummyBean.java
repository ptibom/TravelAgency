package se.computerscience.travelagency.model.persistence;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Philip Tibom
 */
@Stateless
public class DummyBean {

    @PersistenceContext
    private EntityManager em;
    
    
}