<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.persistence.Control" %>
<%@ page import="com.persistence.database.BillChargingDao" %>
<%@ page import="com.persistence.database.impl.DefaultBillChargingDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String message;
    Control control= Control.getInstance();
%>
<head>
  <style>
    label{
      color: whitesmoke;
      font-size: 17px;
      text-transform: capitalize;
    }
  </style>
  <title>Title</title>
  <link rel="stylesheet" href="styles/welcome.css" >
  <link rel="stylesheet" href="styles/bigCover.css">
</head>
<body>
  <div class="Bigcover">
        <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="regisAppl">
        <%
            DecimalFormat dFormat=new DecimalFormat("####, ####, ####, ####");
            message= Control.getToken().getToken();
            long mess=Long.parseLong(message);
            BillChargingDao dao=new DefaultBillChargingDao();
            try {
                dao.addBill(control.getBillCharge(),Control.getToken());
            } catch (SQLException e) {
                System.out.println("ss");
                throw new RuntimeException(e);
            }
        %>
        <p style="color:white; font-size: 25px">Your 16 digit Token: <%=dFormat.format(mess)%></p>
    </div>
  </div>

</body>
</html>
