package se.computerscience.model.persistance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hossein
 */
@Stateless
public class SessionBean {

    @PersistenceContext
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
}