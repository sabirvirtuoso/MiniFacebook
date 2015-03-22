package org.facebook.services;

import org.facebook.dao.DeleteDAOImpl;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class DeleteHandlerImpl {

    private DeleteDAOImpl deleteDAO = new DeleteDAOImpl();

    public void deleteUser(int userId) {
        deleteDAO.deleteUserDAO(userId);
    }

    public void deleteStatus(int statusId, int userId) {
        deleteDAO.deleteStatusDAO(statusId, userId);
    }

    public void deleteComment(int statusId, int commentId, int userId) {
        deleteDAO.deleteCommentDAO(statusId, commentId, userId);
    }

    public void deleteMessage(int messageId) {
        deleteDAO.deleteMessageDAO(messageId);
    }

    public void deleteFriend(int friendId, int userId) {
        deleteDAO.deleteFriendDAO(friendId, userId);
    }
}
