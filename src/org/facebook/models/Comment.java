package org.facebook.models;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class Comment {

    private int statusId;
    private int commentId;
    private String userNameOfComment;
    private String commentText;
    private String dateTimeOfComment;
    private int userIdOfComment;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserNameOfComment() {
        return userNameOfComment;
    }

    public void setUserNameOfComment(String userNameOfComment) {
        this.userNameOfComment = userNameOfComment;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getDateTimeOfComment() {
        return dateTimeOfComment;
    }

    public void setDateTimeOfComment(String dateTimeOfComment) {
        this.dateTimeOfComment = dateTimeOfComment;
    }

    public int getUserIdOfComment() {
        return userIdOfComment;
    }

    public void setUserIdOfComment(int userIdOfComment) {
        this.userIdOfComment = userIdOfComment;
    }
}
