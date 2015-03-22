package org.facebook.controllers;

import org.facebook.models.Post;
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
 * Created by Tanveer on 3/11/2015.
 */
@WebServlet(value="/poststatus", name="PostStatusController")
public class PostStatusController extends HttpServlet {

    private InsertHandlerImpl insertHandler;

    @Override
    public void init() throws ServletException {
        super.init();
        insertHandler =  new InsertHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        String statusText = request.getParameter("status");
        String dateTimeOfStatus = new DateFormatterImpl().returnCurrentDate();

        Post post = new Post();
        post.setUserIdOfStatus(loggedInUserId);
        post.setStatusText(statusText);
        post.setDateTimeOfStatus(dateTimeOfStatus);

        insertHandler.insertStatusOfUser(post);

        response.sendRedirect("home?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
