/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.dao;

/**
 *
 * @author Tanveer
 */
public interface DeleteDAO {

    void deleteCommentDAO(int statusId, int commentId, int userId);

    void deleteFriendDAO(int friendId, int userId);

    void deleteMessageDAO(int messageId);

    void deleteStatusDAO(int statusId, int userId);

    void deleteUserDAO(int userId);
    
}
