/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.dao;

import org.facebook.models.User;

import java.util.List;

/**
 *
 * @author Tanveer
 */
public interface LoginDAO {

    List<User> loginUserDAO(String email, String password);
    
}
