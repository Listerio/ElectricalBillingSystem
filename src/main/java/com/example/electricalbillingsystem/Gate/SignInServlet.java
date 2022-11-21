package com.example.electricalbillingsystem.Gate;

import com.persistence.Control;
import com.persistence.entities.User;
import com.persistence.services.UserManagementService;
import com.persistence.services.impl.DefaultUserManagementService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    String email;
    String password;
    String error;
    Control control;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email=request.getParameter("Semail");
        password=request.getParameter("Spassword");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email=request.getParameter("Semail");
        password=request.getParameter("Spassword");
        if (email.isBlank()||password.isBlank()) {
               error = "Cannot leave a space blank";
               redirectToIndexjsp(request,response);
        }
        UserManagementService service=new DefaultUserManagementService();
        User user=service.getUser(email,password);
        if(user!=null){
            System.out.println("logged in");
            control=Control.getInstance();
            control.setLoggedInUser(user);
            System.out.println(control.getLoggedInUser().getUserName());
            request.getRequestDispatcher("welcomePage.jsp").forward(request,response);
        }
        else {
            error="invalid login parameters";
            System.out.println("login failed");
            redirectToIndexjsp(request,response);
        }
    }
    private void redirectToIndexjsp(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Serror",error);
        request.setAttribute("Semail",email);
        request.setAttribute("Spassword",password);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
