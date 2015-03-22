package org.facebook.services;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.facebook.dao.RetrieveDAOImpl;
import org.facebook.dao.UpdateDAOImpl;
import org.facebook.models.User;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class UpdateHandlerImpl{

    private UpdateDAOImpl updateDAO = new UpdateDAOImpl();

    public void updateStatus(int userId, int statusId, String status_text) {
        updateDAO.updateStatusDAO(userId, statusId, status_text);
    }

    public void updateUser(User user) {
        updateDAO.updateUserDAO(user);
    }
}
