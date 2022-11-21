package com.example.electricalbillingsystem;

import com.persistence.Control;
import com.persistence.entities.BillCharge;
import com.persistence.entities.impl.DefaultBillCharge;
import com.persistence.services.impl.DefaultBillChargingManagement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet(name = "BillServlet", value = "/bill")
public class BillServlet extends HttpServlet {
    DefaultBillChargingManagement management=new DefaultBillChargingManagement();
    Control control= Control.getInstance();
    BillCharge charge=new DefaultBillCharge();
    DecimalFormat format=new DecimalFormat("###,###.##");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        management.setUser(control.getLoggedInUser());
        charge.setFixCharge(10);
        charge.setMaintainanceCharge(100);
        charge.setTotalUnit(management.getTotal_K_W_H_perMonth());
        charge.setTotalCharge((int) management.getTotalBillingCharge());
        control.setBillCharge(charge);

        request.setAttribute("maintain",format.format(charge.getMaintainanceCharge()));
        request.setAttribute("fixed", format.format(charge.getFixCharge()));
        request.setAttribute("uCharge",format.format(charge.getTotalCharge()));
        request.setAttribute("gTotal",format.format(charge.getGrandTotal()));
        request.getRequestDispatcher("billgenerator.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("payment.jsp").forward(request,response);
    }

}
