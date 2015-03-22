/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.dao;


import java.util.List;

import org.facebook.dao.rowmappers.UserRowMapper;
import org.facebook.models.User;
import org.facebook.utils.DatabaseTemplate;

/**
 * @author Tanveer
 */
public class LoginDAOImpl implements LoginDAO {

    @Override
    public List<User> loginUserDAO(String email, String password) {
        String sql = "SELECT * FROM profile_details WHERE email=? AND password=?";
        return DatabaseTemplate.queryForObject(sql, new UserRowMapper(), email, password);
    }
}
