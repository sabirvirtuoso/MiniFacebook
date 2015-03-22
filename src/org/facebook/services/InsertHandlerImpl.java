package org.facebook.services;

import org.facebook.dao.DeleteDAOImpl;
import org.facebook.dao.InsertDAOImpl;
import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class InsertHandlerImpl {

    private InsertDAOImpl insertDAO = new InsertDAOImpl();

    public void insertRegistrationDataOfUser(User user) {
        insertDAO.insertRegistrationDataOfUserDAO(user);
    }

    public void insertStatusOfUser(Post post) {
        insertDAO.insertStatusOfUserDAO(post);
    }

    public void insertCommentOfStatus(Comment comment) {
        insertDAO.insertCommentOfStatusDAO(comment);
    }

    public void insertMessage(Message message) {
        insertDAO.insertMessageDAO(message);
    }

    public void addFriend(int friendId, int userId, String dateTimeOfRequest) {
        insertDAO.addFriendDAO(friendId, userId, dateTimeOfRequest);
    }
}
