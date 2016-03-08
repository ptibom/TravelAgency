package se.computerscience.travelagency.model.persistence;

import java.util.List;

/**
 *
 * @author Hossein
 */
public interface IDAO<T> {
    public void create(T t);
    public void update(T t);
    public void delete(Long id/*, Entities ent*/);
    public List<T> findAll(/*Entities ent*/);
    public T findById(Long id/*, Entities ent*/);
}
