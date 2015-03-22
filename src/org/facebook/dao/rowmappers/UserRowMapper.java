package org.facebook.dao.rowmappers;

import org.facebook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 2/11/15.
 */
public class UserRowMapper implements ObjectRowMapper<User> {

    @Override
    public User mapRowToObject(ResultSet result) throws SQLException {
        User user = new User();
        user.setUserId(result.getInt("user_id"));
        user.setFirstName(result.getString("first_name"));
        user.setLastName(result.getString("last_name"));
        user.setDob(result.getString("DOB"));
        user.setAddress(result.getString("Address"));
        user.setOccupation(result.getString("Occupation"));
        user.setEmail(result.getString("email"));
        user.setPassword(result.getString("password"));
        user.setProfilePictureName(result.getString("profile_picture"));

        return user;
    }
}
