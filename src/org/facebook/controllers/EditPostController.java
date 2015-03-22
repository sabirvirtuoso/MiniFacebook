package org.facebook.controllers;

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

/**
 * Created by Tanveer on 3/12/2015.
 */
@WebServlet(value="/editpost", name="EditPostController")
public class EditPostController extends HttpServlet {

    private UpdateHandlerImpl updateHandlerImpl;
    private RetrieveHandlerImpl retrieveHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        updateHandlerImpl = new UpdateHandlerImpl();
        retrieveHandlerImpl =  new RetrieveHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        int statusId = Integer.parseInt(request.getParameter("statusid"));
        String status = request.getParameter("status");

        updateHandlerImpl.updateStatus(loggedInUserId, statusId, status);

        response.sendRedirect("editpost?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ((User) request.getSession().getAttribute("user"));
        user.setPosts(retrieveHandlerImpl.getAllPostsAndComments(user.getUserId(), false));

        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/editpost.jsp");
        view.forward(request, response);
    }
}
