package com.example.electricalbillingsystem.Gate;

import com.persistence.Control;
import com.persistence.entities.User;
import com.persistence.entities.impl.DefaultUser;
import com.persistence.services.UserManagementService;
import com.persistence.services.impl.DefaultUserManagementService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


    UserManagementService service = new DefaultUserManagementService();
    String errorMessage;
    String firstName;
    String lastName;
    String userName;
    String email;
    String password;
    String cPassword;
    String address;
    Control c;
    @Override
    public void init() throws ServletException {
        super.init();
         c=Control.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errorMessage = request.getParameter("error");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        userName = request.getParameter("userName");
        email = request.getParameter("email");
        password = request.getParameter("password");
        cPassword = request.getParameter("cPassword");
        address = request.getParameter("address");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        errorMessage = request.getParameter("error");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        userName = request.getParameter("userName");
        email = request.getParameter("email");
        password = request.getParameter("password");
        cPassword = request.getParameter("cPassword");
        address = request.getParameter("address");

        if (firstName.isBlank() ||
                lastName.isBlank() ||userName.isBlank() ||
                email.isBlank()||password.isBlank()||cPassword.isBlank()||address.isBlank()) {
            errorMessage="spaces cannot be left blank";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if (!password.equals(cPassword)) {
            errorMessage="Password and confirm password does not match";
            request.setAttribute("error",errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        else {
            User user1;
            user1=new DefaultUser(firstName,lastName,userName,email,password,address);
            User user2=service.getUser(email,password);
            if (user2==null) {
                service.registerUser(user1);
                c.setLoggedInUser(user1);
                request.getRequestDispatcher("welcomePage.jsp").forward(request,response);
            }
            else {
                errorMessage="user already exists";
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }

}