package org.facebook.dao;

import org.facebook.models.Comment;
import org.facebook.models.Message;
import org.facebook.models.Post;
import org.facebook.models.User;

/**
 * Created by Tanveer on 3/19/2015.
 */
public interface InsertDAO {
    void insertRegistrationDataOfUserDAO(User user);

    void insertStatusOfUserDAO(Post post);

    void insertCommentOfStatusDAO(Comment comment);

    void insertMessageDAO(Message message);

    void addFriendDAO(int friendId, int userId, String dateTimeOfRequest);
}
