package org.facebook.dao;

import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;
import org.facebook.utils.DatabaseTemplate;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class InsertDAOImpl implements InsertDAO{

    @Override
    public void insertRegistrationDataOfUserDAO(User user) {
        String sql = "INSERT INTO profile_details (email,password,first_name,last_name,DOB,Address,Occupation, profile_picture)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseTemplate.executeUpdate(sql, user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getDob(), user.getAddress(), user.getOccupation(), user.getProfilePictureName());
    }

    @Override
    public void insertStatusOfUserDAO(Post post) {
        String sql = "INSERT INTO status_updates (user_id_of_status,status_text,date_time_of_status)"
                + "VALUES (?, ?, ?)";
        DatabaseTemplate.executeUpdate(sql, post.getUserIdOfStatus(), post.getStatusText(), post.getDateTimeOfStatus());
    }

    @Override
    public void insertCommentOfStatusDAO(Comment comment) {
        String sql = "INSERT INTO comments (status_id,comment_text,date_time_of_comment,user_id_of_comment)"
                + "VALUES (?, ?, ?, ?)";
        DatabaseTemplate.executeUpdate(sql, comment.getStatusId(), comment.getCommentText(), comment.getDateTimeOfComment(), comment.getUserIdOfComment());
    }

    @Override
    public void insertMessageDAO(Message message) {
        String sql = "INSERT INTO messages (user_id_of_sender,user_id_of_receiver,message_text,date_time_of_message)"
                + "VALUES (?, ?, ?, ?)";
        DatabaseTemplate.executeUpdate(sql, message.getUserIdOfSender(), message.getUserIdOfReceiver(), message.getMessageText(), message.getDateTimeOfMessage());
    }

    @Override
    public void addFriendDAO(int friendId, int userId, String dateTimeOfRequest) {
        String sql = "INSERT INTO friends (friend_id,user_id,date_time_of_request)"
                + "VALUES (?, ?, ?)";
        DatabaseTemplate.executeUpdate(sql, friendId, userId, dateTimeOfRequest);
        DatabaseTemplate.executeUpdate(sql, userId, friendId, dateTimeOfRequest);
    }
}
