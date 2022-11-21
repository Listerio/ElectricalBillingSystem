package com.example.electricalbillingsystem;

import com.persistence.Control;
import com.persistence.database.BillChargingDao;
import com.persistence.database.impl.DefaultBillChargingDao;
import com.persistence.entities.BillCharge;
import com.persistence.entities.Token;
import com.persistence.entities.impl.DefaultBillCharge;
import com.persistence.entities.impl.DefaultToken;
import com.persistence.services.impl.DefaultBillChargingManagement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

@WebServlet(name = "PayServlet", value = "/pay")
public class PayServlet extends HttpServlet {
    DefaultBillChargingManagement management=new DefaultBillChargingManagement();
    Control control= Control.getInstance();
    String cNum;
    String eDate;
    String cV;
    String error;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        management.setUser(control.getLoggedInUser());
        cNum=request.getParameter("cNumber");
        eDate=request.getParameter("eDate");
        cV=request.getParameter("cV");

        if (cNum.isBlank() || eDate.isBlank() || cV.isBlank()) {
            error = "Cannot have empty boxes";
            methodToAccountJsp(request,response,error);
        }
        else if (cNum.length()<16|| cV.length()<3){
            error="Incorrect input param";
            methodToAccountJsp(request,response,error);
        }
        else if (cNum.length()==16 && cV.length()==3){
           request.getRequestDispatcher("token.jsp").forward(request,response);
        }
    }
    void methodToAccountJsp(HttpServletRequest request,HttpServletResponse response,String error) throws ServletException, IOException {
        request.setAttribute("cNumber",cNum);
        request.setAttribute("eDate",eDate);
        request.setAttribute("cV",cV);
        request.setAttribute("e1rror",error);
        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }


}
