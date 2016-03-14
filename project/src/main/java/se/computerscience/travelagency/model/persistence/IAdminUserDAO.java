/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.model.persistence;

import java.util.List;

/**
 *
 * @author Hossein
 */
public interface IAdminUserDAO extends IDAO<AdminUser> {
    public List<AdminUser> findByIDandPw(String uid, String pw);
}
