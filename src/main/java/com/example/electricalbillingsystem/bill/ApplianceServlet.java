package com.example.electricalbillingsystem.bill;

import com.persistence.Control;
import com.persistence.entities.Appliance;
import com.persistence.entities.impl.DefaultAppliance;
import com.persistence.services.ApplianceService;
import com.persistence.services.impl.DefaultApplianceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ApplianceServlet", value = "/ApplianceServlet")
public class ApplianceServlet extends HttpServlet {

    ApplianceService service;
    Control control;
    Appliance appliance;
    String applianceName;
    String numberOfApp;
    String power;
    String time;
    String error;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        applianceName=request.getParameter("aplName");
        numberOfApp=request.getParameter("aplNumber");
        power=request.getParameter("power");
        time=request.getParameter("time");
        error=request.getParameter("acc_error");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        applianceName = request.getParameter("aplName");
        numberOfApp = request.getParameter("aplNumber");
        power = request.getParameter("power");
        time = request.getParameter("time");

        if (applianceName.isBlank() || numberOfApp.isBlank() || power.isBlank() || time.isBlank()) {
            error = "Cannot have empty boxes";
            methodToAccountJsp(request,response,error);
        }

        int numberOfAppliance = Integer.parseInt(numberOfApp);
        int powerOfAppliance = Integer.parseInt(power);
        double TimeOfAppliance = Double.parseDouble(time);
        if (TimeOfAppliance>24.0){
            error="time cannot be more than 24hrs";
            methodToAccountJsp(request,response,error);
        }
        appliance=new DefaultAppliance();
        appliance.setApplianceName(applianceName);
        appliance.setNumberOfAppliance(numberOfAppliance);
        appliance.setAppliancePower(powerOfAppliance);
        appliance.setTimeUsed(TimeOfAppliance);
        control=Control.getInstance();
        service=new DefaultApplianceService();

        List<Appliance> appliances = service.getAppliancePerUserId(control.getLoggedInUser().getConsumerId());
        for (Appliance ap : appliances) {
            if (ap.getApplianceName().equals(appliance.getApplianceName())) {
                error = "appliance already registered";
                methodToAccountJsp(request,response,error);

            }
        }
        System.out.println("passed here");
        service.registerAppliance(control.getLoggedInUser(), appliance);
        control.setAppliance(appliance);
        request.getRequestDispatcher("welcomePage.jsp").forward(request,response);
    }

    void methodToAccountJsp(HttpServletRequest request,HttpServletResponse response,String error) throws ServletException, IOException {
        request.setAttribute("aplName",applianceName);
        request.setAttribute("aplNumber",numberOfApp);
        request.setAttribute("power",power);
        request.setAttribute("time",time);
        request.setAttribute("acc_error",error);
        request.getRequestDispatcher("appliance.jsp").forward(request, response);
    }














}