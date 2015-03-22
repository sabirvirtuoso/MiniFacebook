/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.services;

import java.util.List;

import org.facebook.dao.LoginDAOImpl;
import org.facebook.models.User;

/**
 *
 * @author Tanveer
 */
public class LoginHandlerImpl {

    public User loginUser(String email, String password) {
        List<User> user = new LoginDAOImpl().loginUserDAO(email, password);
        if(user.size() > 0)
            return user.get(0);
        else
            return null;
    }
}
