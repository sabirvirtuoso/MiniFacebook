package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.RetrieveHandlerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tanveer on 3/12/2015.
 */
@WebServlet(value="/viewusers", name="ViewUsersController")
public class ViewUsersController extends HttpServlet {

    private RetrieveHandlerImpl retrieveHandler;

    @Override
    public void init() throws ServletException {
        super.init();
        retrieveHandler =  new RetrieveHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();

        List<User> nonFriends = retrieveHandler.getAllNonFriendUsers(loggedInUserId);
        List<User> friends = retrieveHandler.getAllFriends(loggedInUserId);

        request.setAttribute("nonfriends", nonFriends);
        request.setAttribute("friends", friends);

        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/viewusers.jsp");
        view.forward(request, response);
    }
}
