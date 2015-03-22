package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.LoginHandlerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tanveer on 3/11/2015.
 */
@WebServlet(value="/login", name="LoginController")
public class LoginController extends javax.servlet.http.HttpServlet {

    private static final int MAX_COOKIE_DURATION_IN_SECONDS = 30*60;
    private LoginHandlerImpl loginHandlerImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        loginHandlerImpl =  new LoginHandlerImpl();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User loggedInUser = loginHandlerImpl.loginUser(email, password);

        if (loggedInUser == null) {
            response.sendRedirect("login?failure=1");

            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", loggedInUser);

        if (isRememberMeSelected(request)) {
            Cookie cookie = new Cookie("userId", String.valueOf(loggedInUser.getUserId()));
            cookie.setMaxAge(MAX_COOKIE_DURATION_IN_SECONDS);
            response.addCookie(cookie);
        }

        response.sendRedirect("home");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("views/pages/login.jsp");
        view.forward(request, response);
    }

    private boolean isRememberMeSelected(HttpServletRequest request) {
        return (request.getParameter("rememberme") != null && request.getParameter("rememberme").equals("on"));
    }
}
