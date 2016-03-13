/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Hossein
 */
@Stateless
public class AdminUserDAO extends GeneralDAO<AdminUser> implements IAdminUserDAO {
    
    public AdminUserDAO() {
        super(AdminUser.class);
    }

    @Override
    public List<AdminUser> findByIDandPw(String uid, String pw) {
        return em.createQuery("SELECT t FROM AdminUser t WHERE t.name = :uid AND t.pw = :pw")
                .setParameter("uid", uid)
                .setParameter("pw", pw)
                .getResultList();
    }
    
}
