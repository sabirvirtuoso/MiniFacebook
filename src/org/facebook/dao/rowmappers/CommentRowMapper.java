package org.facebook.dao.rowmappers;

import org.facebook.models.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 2/11/15.
 */
public class CommentRowMapper implements ObjectRowMapper<Comment> {

    @Override
    public Comment mapRowToObject(ResultSet result) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentText(result.getString("comment_text"));
        comment.setCommentId(result.getInt("comment_id"));
        comment.setStatusId(result.getInt("status_id"));
        comment.setDateTimeOfComment(removeMilliseconds(result.getString("date_time_of_comment")));
        comment.setUserIdOfComment(result.getInt("user_id_of_comment"));

        return comment;
    }

    private String removeMilliseconds(String dateTime) {

        return dateTime != null ? dateTime.split("\\.")[0].toString() : dateTime;
    }
}
