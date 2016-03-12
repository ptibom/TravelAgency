package se.computerscience.travelagency.model.persistence;

import lombok.Getter;

/**
 *
 * @author hossein
 */
public class User {
    
    @Getter
    private final String name;

    public User(String name) {
        this.name = name;
    }   
}
