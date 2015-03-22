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
 * Created by Tanveer on 3/14/2015.
 */
@WebServlet(value="/updateprofile", name="ProfileUpdateController")
public class ProfileUpdateController extends HttpServlet {

    private UpdateHandlerImpl updateHandler;
    private RetrieveHandlerImpl retrieveHandler;

    @Override
    public void init() throws ServletException {
        super.init();
        updateHandler =  new UpdateHandlerImpl();
        retrieveHandler = new RetrieveHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String occupation = request.getParameter("occupation");

        User user = new User();
        user.setUserId(loggedInUserId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setDob(dob);
        user.setAddress(address);
        user.setOccupation(occupation);

        updateHandler.updateUser(user);

        response.sendRedirect("/updateprofile?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int loggedInUserId = ((User) request.getSession().getAttribute("user")).getUserId();

        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", retrieveHandler.getSpecificUser(loggedInUserId));

        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/updateinfo.jsp");
        view.forward(request, response);
    }
}
