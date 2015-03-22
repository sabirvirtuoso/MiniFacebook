package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.InsertHandlerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tanveer on 3/11/2015.
 */
@WebServlet(value="/register", name="RegistrationController")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
        maxFileSize=1024*1024*50,          // 50 MB
        maxRequestSize=1024*1024*100)
public class RegistrationController extends HttpServlet {

    private InsertHandlerImpl insertHandler;
    private static final String UPLOAD_DIR = "uploads";

    @Override
    public void init() throws ServletException {
        super.init();
        insertHandler =  new InsertHandlerImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String occupation = request.getParameter("occupation");
        String profilePicName = new FileUploadController().uploadFile(request);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setDob(dob);
        user.setAddress(address);
        user.setOccupation(occupation);
        user.setProfilePictureName(profilePicName);

        insertHandler.insertRegistrationDataOfUser(user);

        response.sendRedirect("register?success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        view = request.getRequestDispatcher("views/pages/registration.jsp");
        view.forward(request, response);
    }
}
