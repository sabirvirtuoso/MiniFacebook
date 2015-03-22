package org.facebook.services;

import org.facebook.dao.InsertDAOImpl;
import org.facebook.dao.RetrieveDAO;
import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.facebook.dao.RetrieveDAOImpl;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class RetrieveHandlerImpl {

    private RetrieveDAOImpl retrieveDAO = new RetrieveDAOImpl();
    private List<Post> posts;
    private List<Comment> comments;
    private List<Message> messages;

    public List<User> getAllUsers(int userId) {

        return retrieveDAO.getAllUsersDAO(userId);
    }

    public List<User> getAllFriends(int userId) {

        return (ArrayList<User>) retrieveDAO.getAllFriendsDAO(userId);
    }

    public List<User> getAllNonFriendUsers(int userId) {

        return (ArrayList<User>) retrieveDAO.getAllNonFriendUsersDAO(userId);
    }

    public User getSpecificUser(int userId) {

        return (retrieveDAO.getSpecificUserDAO(userId)).get(0);
    }

    public List<Post> getAllPostsAndComments(int loggedInUserId, boolean FriendPosts) {
        List<Post> posts;

        if (FriendPosts) {
            posts = getAllFriendsStatus(loggedInUserId);
        } else {
            posts = getAllPersonalStatus(loggedInUserId);
        }

        for (Post post : posts) {
            post.setComments(getCommentsOfSpecificStatus(post.getStatusId()));
        }

        return posts;
    }

    public List<Post> getAllPersonalStatus(int userId) {
        posts = retrieveDAO.getAllPersonalStatusDAO(userId);

        for (Post post : posts) {
            post.setUserNameOfStatus(getSpecificUser(post.getUserIdOfStatus()).getFullName());
        }

        return posts;
    }

    public List<Post> getAllFriendsStatus(int userId) {
        posts = retrieveDAO.getAllFriendsStatusDAO(userId);

        for (Post post : posts) {
            post.setUserNameOfStatus(getSpecificUser(post.getUserIdOfStatus()).getFullName());
        }

        return posts;
    }

    public List<Post> getSpecificStatus(int userId) {

        return (ArrayList<Post>) retrieveDAO.getSpecificStatusDAO(userId);
    }

    public List<Comment> getCommentsOfSpecificStatus(int statusId) {
        comments = retrieveDAO.getCommentsOfSpecificStatusDAO(statusId);

        for (Comment comment : comments) {
            comment.setUserNameOfComment(getSpecificUser(comment.getUserIdOfComment()).getFullName());
        }

        return comments;
    }

    public List<Message> getAllSentMessages(int userId) {
        messages = retrieveDAO.getAllSentMessagesDAO(userId);

        for (Message message : messages) {
            message.setUserName(getSpecificUser(message.getUserIdOfReceiver()).getFullName());
        }

        return messages;
    }

    public List<Message> getAllReceivedMessages(int userId) {
        messages = retrieveDAO.getAllReceivedMessagesDAO(userId);

        for (Message message : messages) {
            message.setUserName(getSpecificUser(message.getUserIdOfSender()).getFullName());
        }

        return messages;
    }

    public List<Message> getMessagesByReceiver(int userId, int receiverId) {

        return (ArrayList<Message>) retrieveDAO.getMessagesByReceiverDAO(userId, receiverId);
    }
}
