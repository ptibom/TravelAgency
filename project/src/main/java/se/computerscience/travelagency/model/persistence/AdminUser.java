package se.computerscience.travelagency.model.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hossein
 */
@Entity
public class AdminUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    
    
    @Getter
    @Setter
    @Column(nullable = false)
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
