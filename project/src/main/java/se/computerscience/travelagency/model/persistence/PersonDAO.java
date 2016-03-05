/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hossein
 */
@Stateless
public class PersonDAO<T> implements IDAO<T> {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(T t) {
        em.persist(t);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>)em.createQuery("SELECT p FROM Person p")
                .getResultList();
    }
}
