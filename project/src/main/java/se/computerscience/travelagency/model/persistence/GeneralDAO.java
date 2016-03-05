package se.computerscience.travelagency.model.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilities.Entities;

/**
 *
 * @author Hossein
 */
//@Stateless// to return remove comment and abstract
public abstract class GeneralDAO<T> implements IDAO<T> {
    
    @PersistenceContext
    
    protected EntityManager em;

    @Override
    public void create(T t) {
        em.persist(t);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public List<T> findAll(Entities entities) {
        return (List<T>)em.createQuery("SELECT t FROM " + entities.type + " t")
                .getResultList();
    }

    @Override
    public void delete(Long id, Entities ent) {
        Class<T> entClass = ent.cls;
        T t = em.getReference(entClass, id);
        em.remove(t);
    }

    @Override
    public T findById(Long id, Entities ent) {
        Class<T> entClass = ent.cls;
        T t = em.find(entClass, id);
        return t;
    }
}
