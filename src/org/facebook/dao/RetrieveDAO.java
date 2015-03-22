package org.facebook.dao;

import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;

import java.util.List;

/**
 * Created by Tanveer on 3/19/2015.
 */
public interface RetrieveDAO {
    List<User> getAllNonFriendUsersDAO(int userId);

    List<User> getAllUsersDAO(int userId);

    List<User> getSpecificUserDAO(int userId);

    List<Post> getAllPersonalStatusDAO(int userId);

    List<Post> getAllFriendsStatusDAO(int userId);

    List<Post> getSpecificStatusDAO(int userId);

    List<Comment> getCommentsOfSpecificStatusDAO(int statusId);

    List<Message> getAllSentMessagesDAO(int userId);

    List<Message> getAllReceivedMessagesDAO(int userId);

    List<Message> getMessagesByReceiverDAO(int userId, int receiverId);

    List<User> getAllFriendsDAO(int userId);
}
