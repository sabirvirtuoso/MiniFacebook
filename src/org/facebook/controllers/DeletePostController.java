package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.DeleteHandlerImpl;
import org.facebook.services.RetrieveHandlerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/deletepost", name="DeletePostController")
public class DeletePostController extends HttpServlet {

    private DeleteHandlerImpl deleteHandlerImpl;
    private RetrieveHandlerImpl retrieveHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        deleteHandlerImpl = new DeleteHandlerImpl();
        retrieveHandlerImpl =  new RetrieveHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        int statusId = Integer.parseInt(request.getParameter("statusid"));

        deleteHandlerImpl.deleteStatus(statusId, loggedInUserId);

        response.sendRedirect("deletepost?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ((User) request.getSession().getAttribute("user"));
        user.setPosts(retrieveHandlerImpl.getAllPostsAndComments(user.getUserId(), false));

        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/deletepost.jsp");
        view.forward(request, response);
    }
}
