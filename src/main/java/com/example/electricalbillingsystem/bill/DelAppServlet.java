package com.example.electricalbillingsystem.bill;

import com.persistence.Control;
import com.persistence.entities.Appliance;
import com.persistence.services.ApplianceService;
import com.persistence.services.impl.DefaultApplianceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DelAppServlet", value = "/delApp")
public class DelAppServlet extends HttpServlet {
    ApplianceService service;

    Control control;

    Appliance appliance;
    String applianceName;
    String error;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        applianceName = request.getParameter("DaplName");
        error = request.getParameter("Dacc_error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        applianceName = request.getParameter("DaplName");
        if(applianceName.isBlank()){
            error="cannot leave empty spaces";
            methodToEditJsp(request,response,error);
        }
        service=new DefaultApplianceService();
        control=Control.getInstance();
        appliance=service.retrieveAppliance(control.getLoggedInUser(),applianceName);
        if(appliance==null){
            error="appliance does not exist";
            methodToEditJsp(request,response,error);
        }
        else {
            service.deleteAppliance(control.getLoggedInUser(),appliance);
            request.getRequestDispatcher("welcomePage.jsp").forward(request,response);
        }
    }

    void methodToEditJsp(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("DaplName", applianceName);
        request.setAttribute("Dacc_error", error);
        request.getRequestDispatcher("delAppliance.jsp").forward(request, response);
    }
}