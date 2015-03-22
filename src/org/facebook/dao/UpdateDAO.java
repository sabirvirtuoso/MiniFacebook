/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.dao;

import org.facebook.models.User;

/**
 *
 * @author Tanveer
 */
public interface UpdateDAO {

    void updateStatusDAO(int userId, int statusId, String status_text);

    void updateUserDAO(User user);
}
