<%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 26/10/2022
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

     <title>Title</title>
<link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
        <div class="registration-form">
            <h1>Register Here</h1>
            <p style="color:red; font-size: 15px">${error}</p>
            <form action="RegistrationServlet" method="post">
            <input name="firstName" type="text" placeholder="first name" value="${firstName}">
            <input name="lastName" type="text" placeholder="Last name" value="${lastName}">
            <input name="userName" type="text" placeholder="User name" value="${userName}">
            <input name="email" type="email" placeholder="email" value="${email}">
            <input name="password" type="password" placeholder="password" value="${password}">
            <input name="cPassword" type="password" placeholder="Confirm password" value="${cPassword}">
            <input name="address" type="text" placeholder="Address" value="${address}">
            <button type="submit">Register</button>
            </form>
        </div>





</body>

</html>
