package org.facebook.dao;

import org.facebook.utils.DatabaseTemplate;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class DeleteDAOImpl implements DeleteDAO {

    @Override
    public void deleteUserDAO(int userId) {
        String sql = "DELETE FROM profile_details WHERE user_id=?";
        DatabaseTemplate.executeUpdate(sql, userId);
    }

    @Override
    public void deleteStatusDAO(int statusId, int userId) {
        String sql = "DELETE FROM status_updates WHERE status_id=? AND user_id_of_status=?";
        DatabaseTemplate.executeUpdate(sql, statusId, userId);
    }

    @Override
    public void deleteCommentDAO(int statusId, int commentId, int userId) {
        String sql = "DELETE FROM comments WHERE status_id=? AND comment_id=? AND user_id_of_comment=?";
        DatabaseTemplate.executeUpdate(sql, statusId, commentId, userId);
    }

    @Override
    public void deleteMessageDAO(int messageId) {
        String sql = "DELETE FROM messages WHERE message_id=?";
        DatabaseTemplate.executeUpdate(sql, messageId);
    }

    @Override
    public void deleteFriendDAO(int friendId, int userId) {
        String sql = "DELETE FROM friends WHERE friend_id=? AND user_id=?";
        DatabaseTemplate.executeUpdate(sql, friendId, userId);
    }
}
