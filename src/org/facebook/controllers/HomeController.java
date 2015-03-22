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

/**
 * Created by Tanveer on 3/11/2015.
 */
@WebServlet(value="/home", name="HomeController")
public class HomeController extends HttpServlet {

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
        user.setPosts(retrieveHandlerImpl.getAllPostsAndComments(user.getUserId(), false));

        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/home.jsp");
        view.forward(request, response);
    }
}
