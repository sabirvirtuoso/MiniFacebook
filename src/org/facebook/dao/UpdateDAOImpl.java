package org.facebook.dao;

import org.facebook.models.User;
import org.facebook.utils.DatabaseTemplate;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class UpdateDAOImpl implements UpdateDAO {

    @Override
    public void updateStatusDAO(int userId, int statusId, String status_text) {
        String sql = "UPDATE status_updates SET status_text=? WHERE status_id=? AND user_id_of_status=?";
        DatabaseTemplate.executeUpdate(sql, status_text, statusId, userId);
    }

    @Override
    public void updateUserDAO(User user) {
        String sql = "UPDATE profile_details SET email =?, password =?, first_name =?, last_name =?, DOB =?, address =?, occupation =? WHERE user_id =?";
        DatabaseTemplate.executeUpdate(sql, user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getDob(), user.getAddress(), user.getOccupation(), user.getUserId());
    }
}
