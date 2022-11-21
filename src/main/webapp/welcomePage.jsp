<%@ page import="com.persistence.entities.User" %>
<%@ page import="com.persistence.entities.Appliance" %>
<%@ page import="com.persistence.Control" %>
<%@ page import="com.persistence.services.ApplianceService" %>
<%@ page import="com.persistence.services.impl.DefaultApplianceService" %>
<%@ page import="java.util.List" %>
 <%@ page import="com.persistence.services.impl.DefaultBillChargingManagement" %><%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 03/11/2022
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    Control control= Control.getInstance();
    Appliance appliance= control.getAppliance();
    User user= control.getLoggedInUser();
    ApplianceService service=new DefaultApplianceService();
%>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="styles/welcome.css" >
    <link rel="stylesheet" href="styles/bigCover.css">
    <link rel="stylesheet"href="styles/table.css">
</head>
<body>
<div class="Bigcover">
<jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="table">
      <table class="content-table">
          <%
              DefaultBillChargingManagement management=new DefaultBillChargingManagement();
              management.setUser(control.getLoggedInUser());
          %>

          <h1>You will consume <%=management.getTotal_K_W_H_perMonth()%></h1>
          <h1>Your Appliances</h1>
        <thead>
        <tr>
            <th>Appliance Id</th>
            <th>Appliance Name</th>
            <th>Watts</th>
            <th>Number</th>
            <th>Hrs/Day</th>
        </tr>
        </thead>
          <tbody>
          <%
              List<Appliance> appliances=service.getAppliancePerUserId(user.getConsumerId());
              for (int i=0; i<appliances.size();i++) {
          %>
                <tr <%if(i%2>0){%>class="backgroundSpan"<%}%>>
                    <td><p><%=i+1%></p></td>
                    <td><p><%=appliances.get(i).getApplianceName()%></p></td>
                    <td ><p><%=appliances.get(i).getAppliancePower()%></p></td>
                    <td><p><%=appliances.get(i).getNumberOfAppliances()%></p></td>
                    <td><p><%=appliances.get(i).getTimeUsed()%></p></td>
                </tr>
          <%
              }
          %>
          </tbody>
     </table>
    </div>
    <div class="buttonDiv">

        <button class="edit"><a  href="editAppliance.jsp">Edit Appliance</a></button>
        <button class="del" ><a  href="delAppliance.jsp"> delete Appliance </a></button>

    </div>
</div>



</body>
</html>
