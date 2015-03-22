/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.facebook.models;

/**
 *
 * @author Tanveer
 */
public class Message {
    
    private int messageId;
    private int userIdOfSender;
    private int userIdOfReceiver;
    private String userName;
    private String messageText;
    private String dateTimeOfMessage;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserIdOfSender() {
        return userIdOfSender;
    }

    public void setUserIdOfSender(int userIdOfSender) {
        this.userIdOfSender = userIdOfSender;
    }

    public int getUserIdOfReceiver() {
        return userIdOfReceiver;
    }

    public void setUserIdOfReceiver(int userIdOfReceiver) {
        this.userIdOfReceiver = userIdOfReceiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getDateTimeOfMessage() {
        return dateTimeOfMessage;
    }

    public void setDateTimeOfMessage(String dateTimeOfMessage) {
        this.dateTimeOfMessage = dateTimeOfMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
