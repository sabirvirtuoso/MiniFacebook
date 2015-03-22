package org.facebook.dao;

import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;
import org.facebook.dao.rowmappers.*;

import java.sql.*;
import java.util.List;

import org.facebook.utils.DatabaseTemplate;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class RetrieveDAOImpl implements RetrieveDAO{

    @Override
    public List<User> getAllNonFriendUsersDAO(int userId) {
        String sql = "SELECT * FROM profile_details where user_id <> ? AND user_id NOT IN (SELECT friend_id from friends where user_id=?)";

        return DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId, userId);
    }

    @Override
    public List<User> getAllFriendsDAO(int userId) {
        String sql = "SELECT * FROM profile_details where user_id <> ? AND user_id IN (SELECT friend_id from friends where user_id=?)";

        return DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId, userId);
    }

    @Override
    public List<User> getAllUsersDAO(int userId) {
        String sql = "SELECT * FROM profile_details where user_id <> ?";

        return DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId);
    }


    @Override
    public List<User> getSpecificUserDAO(int userId){
        String sql = "SELECT * FROM profile_details WHERE user_id=?";

        return DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId);
    }

    @Override
    public List<Post> getAllPersonalStatusDAO(int userId) {
        String sql = "SELECT * FROM status_updates WHERE user_id_of_status=? ORDER BY date_time_of_status DESC";

        return DatabaseTemplate.queryForObject(sql, new PostRowMapper(), userId);
    }

    @Override
    public List<Post> getAllFriendsStatusDAO(int userId) {
        String sql = "SELECT * FROM status_updates WHERE user_id_of_status in "
                + "(SELECT friend_id FROM friends WHERE user_id=?) ORDER BY date_time_of_status DESC";

        return DatabaseTemplate.queryForObject(sql, new PostRowMapper(), userId);
    }

    @Override
    public List<Post> getSpecificStatusDAO(int userId) {
        String sql = "SELECT * FROM status_updates WHERE user_id_of_status=?";

        return DatabaseTemplate.queryForObject(sql, new PostRowMapper(), userId);
    }

    @Override
    public List<Comment> getCommentsOfSpecificStatusDAO(int statusId) {
        String sql = "SELECT * FROM comments WHERE status_id=?";

        return DatabaseTemplate.queryForObject(sql, new CommentRowMapper(), statusId);
    }

    @Override
    public List<Message> getAllSentMessagesDAO(int userId) {
        String sql = "SELECT * FROM messages WHERE user_id_of_sender=?";

        return DatabaseTemplate.queryForObject(sql, new MessageRowMapper(), userId);
    }

    @Override
    public List<Message> getAllReceivedMessagesDAO(int userId) {
        String sql = "SELECT * FROM messages WHERE user_id_of_receiver=?";

        return DatabaseTemplate.queryForObject(sql, new MessageRowMapper(), userId);
    }

    @Override
    public List<Message> getMessagesByReceiverDAO(int userId, int receiverId) {
        String sql = "SELECT * FROM messages WHERE user_id_of_sender=? AND user_id_of_receiver=?";

        return DatabaseTemplate.queryForObject(sql, new MessageRowMapper(), userId, receiverId);
    }
}
