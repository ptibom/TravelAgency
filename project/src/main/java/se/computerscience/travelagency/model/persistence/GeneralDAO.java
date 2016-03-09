package se.computerscience.travelagency.model.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hossein
 */
public abstract class GeneralDAO<T> implements IDAO<T> {
    
    private final Class<T> clazz;
    
    @PersistenceContext
    protected EntityManager em;

    protected GeneralDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public void create(T t) {
        em.persist(t);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public List<T> findAll() {
        return (List<T>)em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t")
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        T t = em.getReference(clazz, id);
        em.remove(t);
    }

    @Override
    public T findById(Long id) {
        T t = em.find(clazz, id);
        return t;
    }
}
