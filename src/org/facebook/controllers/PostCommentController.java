package org.facebook.controllers;

import org.facebook.models.Comment;
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
@WebServlet(value="/postcomment", name="PostCommentController")
public class PostCommentController extends HttpServlet {

    private InsertHandlerImpl insertHandler;

    @Override
    public void init() throws ServletException {
        super.init();
        insertHandler =  new InsertHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        int statusId = Integer.parseInt(request.getParameter("statusid"));
        String dateTimeOfComment = new DateFormatterImpl().returnCurrentDate();
        String commentText = request.getParameter("comment");
        String requestFromPage = request.getParameter("requestfrom");

        Comment comment = new Comment();
        comment.setUserIdOfComment(loggedInUserId);
        comment.setStatusId(statusId);
        comment.setDateTimeOfComment(dateTimeOfComment);
        comment.setCommentText(commentText);

        insertHandler.insertCommentOfStatus(comment);

        if (requestFromPage.equals("home"))
            response.sendRedirect("home?success=1");
        else
            response.sendRedirect("newsfeed?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
