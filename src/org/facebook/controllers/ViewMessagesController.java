package org.facebook.controllers;

import org.facebook.models.Message;
import org.facebook.models.User;
import org.facebook.services.RetrieveHandlerImpl;
import org.facebook.services.UpdateHandlerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanveer on 3/12/2015.
 */
@WebServlet(value="/viewmessage", name="ViewMessagesController")
public class ViewMessagesController extends HttpServlet {

    private RetrieveHandlerImpl retrieveHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        retrieveHandlerImpl =  new RetrieveHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ((User) request.getSession().getAttribute("user"));
        user.setSentMessages(retrieveHandlerImpl.getAllSentMessages(user.getUserId()));
        user.setReceivedMessages(retrieveHandlerImpl.getAllReceivedMessages(user.getUserId()));

        RequestDispatcher view = request.getRequestDispatcher("views/pages/seeallmessages.jsp");
        view.forward(request, response);
    }
}
