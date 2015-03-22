package org.facebook.controllers;

import org.facebook.models.Message;
import org.facebook.models.User;
import org.facebook.services.InsertHandlerImpl;
import org.facebook.utils.DateFormatterImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tanveer on 3/12/2015.
 */
@WebServlet(value="/sendmessage", name="SendMessageController")
public class SendMessageController extends HttpServlet {

    private InsertHandlerImpl insertHandler;

    @Override
    public void init() throws ServletException {
        super.init();
        insertHandler =  new InsertHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        int receiverId = Integer.parseInt(request.getParameter("userid"));
        String messageText = request.getParameter("message");
        String dateTimeOfMessage = new DateFormatterImpl().returnCurrentDate();

        Message message = new Message();
        message.setUserIdOfSender(loggedInUserId);
        message.setUserIdOfReceiver(receiverId);
        message.setMessageText(messageText);
        message.setDateTimeOfMessage(dateTimeOfMessage);

        insertHandler.insertMessage(message);

        response.sendRedirect("viewusers?message=Message Sent Successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
