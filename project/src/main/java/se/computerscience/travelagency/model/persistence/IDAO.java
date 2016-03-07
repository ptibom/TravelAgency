/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.util.List;
import utilities.Entities;

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
