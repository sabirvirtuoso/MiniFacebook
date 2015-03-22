package org.facebook.controllers;

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
 * Created by Tanveer on 3/13/2015.
 */
@WebServlet(value="/addfriend", name="FriendAddController")
public class FriendAddController extends HttpServlet {

    private InsertHandlerImpl insertHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        insertHandlerImpl = new InsertHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        int friendId = Integer.parseInt(request.getParameter("userid"));
        String DatetimeOfAdd = new DateFormatterImpl().returnCurrentDate();

        insertHandlerImpl.addFriend(friendId, loggedInUserId, DatetimeOfAdd);

        response.sendRedirect("viewusers?message=Friend Added Successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
