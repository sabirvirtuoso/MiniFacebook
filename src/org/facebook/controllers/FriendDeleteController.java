package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.DeleteHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tanveer on 3/13/2015.
 */
@WebServlet(value="/deletefriend", name="FriendDeleteController")
public class FriendDeleteController extends HttpServlet {

    private DeleteHandlerImpl deleteHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        deleteHandlerImpl = new DeleteHandlerImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUser = ((User) request.getSession().getAttribute("user")).getUserId();
        int friendId = Integer.parseInt(request.getParameter("userid"));

        deleteHandlerImpl.deleteFriend(friendId, loggedInUser);

        response.sendRedirect("viewusers?message=Friend Deleted Successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
