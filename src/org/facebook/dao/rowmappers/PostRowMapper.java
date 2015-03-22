package org.facebook.dao.rowmappers;

import org.facebook.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 2/11/15.
 */
public class PostRowMapper implements ObjectRowMapper<Post> {

    @Override
    public Post mapRowToObject(ResultSet result) throws SQLException {
        Post status = new Post();
        status.setStatusId(result.getInt("status_id"));
        status.setStatusText(result.getString("status_text"));
        status.setUserIdOfStatus(result.getInt("user_id_of_status"));
        status.setDateTimeOfStatus(removeMilliseconds(result.getString("date_time_of_status")));

        return status;
    }

    private String removeMilliseconds(String dateTime) {

        return dateTime != null ? dateTime.split("\\.")[0].toString() : dateTime;
    }
}
