package org.facebook.dao.rowmappers;

import org.facebook.models.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 2/11/15.
 */
public class MessageRowMapper implements ObjectRowMapper<Message> {

    @Override
    public Message mapRowToObject(ResultSet result) throws SQLException {
        Message message = new Message();
        message.setMessageId(result.getInt("message_id"));
        message.setUserIdOfSender(result.getInt("user_id_of_sender"));
        message.setUserIdOfReceiver(result.getInt("user_id_of_receiver"));
        message.setDateTimeOfMessage(removeMilliseconds(result.getString("date_time_of_message")));
        message.setMessageText(result.getString("message_text"));

        return message;
    }

    private String removeMilliseconds(String dateTime) {

        return dateTime != null ? dateTime.split("\\.")[0].toString() : dateTime;
    }
}
