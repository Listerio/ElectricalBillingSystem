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

@WebServlet(name = "ApplianceEditDelServlet", value = "/editApp")
public class ApplianceEditServlet extends HttpServlet {
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
        applianceName=request.getParameter("EaplName");
        numberOfApp=request.getParameter("EaplNumber");
        power=request.getParameter("Epower");
        time=request.getParameter("Etime");
        error=request.getParameter("Eacc_error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        applianceName = request.getParameter("EaplName");
        numberOfApp = request.getParameter("EaplNumber");
        power = request.getParameter("Epower");
        time = request.getParameter("Etime");

        if (applianceName.isBlank()){
            error="Cannot have empty appliance name";
            methodToEditJsp(request,response,error);
        }
        else if(numberOfApp.isBlank()&&power.isBlank()&&time.isBlank()){
            error="At least change one attribute";
            methodToEditJsp(request,response,error);
        }
        control=Control.getInstance();
        service=new DefaultApplianceService();
        boolean v=false;
        List<Appliance> appliances=service.getAppliancePerUserId(control.getLoggedInUser().getConsumerId());
        Appliance old = null;
        Appliance newApp=null;
        for (Appliance a:appliances) {
            if(a.getApplianceName().trim().equalsIgnoreCase(applianceName.trim())){
                v=true;
                old=a;
                newApp=old;
                break;
            }
        }
        if (v==false){
            error="You dont have this appliance name:  "+applianceName;
            methodToEditJsp(request,response,error);
        }
        else if(v==true){
            int num=old.getNumberOfAppliances();
            double timeq=old.getTimeUsed();
            int watt=old.getAppliancePower();
            try {
                num=Integer.parseInt(numberOfApp);
                timeq=Double.parseDouble(time);
                watt=Integer.parseInt(power);
            }
            catch (NumberFormatException e){

            }finally {
                newApp.setNumberOfAppliance(num);
                newApp.setTimeUsed(timeq);
                newApp.setAppliancePower(watt);
            }
            service.editAppliance(control.getLoggedInUser(),old,newApp);
            request.getRequestDispatcher("welcomePage.jsp").forward(request,response
            );
        }
    }

    void methodToEditJsp(HttpServletRequest request,HttpServletResponse response,String error) throws ServletException, IOException {
        request.setAttribute("EaplName",applianceName);
        request.setAttribute("EaplNumber",numberOfApp);
        request.setAttribute("Epower",power);
        request.setAttribute("Etime",time);
        request.setAttribute("Eacc_error",error);
        request.getRequestDispatcher("editAppliance.jsp").forward(request, response);
    }




}
