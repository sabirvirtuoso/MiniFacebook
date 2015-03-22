package org.facebook.models;

import java.util.List;

/**
 * Created by sabir.salman on 2/8/15.
 */
public class Post {

    private int userIdOfStatus;
    private String userNameOfStatus;
    private String statusText;
    private String dateTimeOfStatus;
    private int statusId;
    private List<Comment> comments;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getUserNameOfStatus() {
        return userNameOfStatus;
    }

    public void setUserNameOfStatus(String userNameOfStatus) {
        this.userNameOfStatus = userNameOfStatus;
    }

    public String getDateTimeOfStatus() {
        return dateTimeOfStatus;
    }

    public void setDateTimeOfStatus(String dateTimeOfStatus) {
        this.dateTimeOfStatus = dateTimeOfStatus;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getUserIdOfStatus() {
        return userIdOfStatus;
    }

    public void setUserIdOfStatus(int userIdOfStatus) {
        this.userIdOfStatus = userIdOfStatus;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
