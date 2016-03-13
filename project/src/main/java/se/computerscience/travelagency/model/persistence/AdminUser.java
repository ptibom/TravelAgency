package se.computerscience.travelagency.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hossein
 */
@Entity
public class AdminUser {
    
    @Getter
    @Id
    @Setter
    private String name;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private String pw;
    
    public AdminUser(){
        
    }

    public AdminUser(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }
}
