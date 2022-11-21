<%--
  Created by IntelliJ IDEA.
  User: Omotola
  Date: 03/11/2022
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="includes/head.jsp"></jsp:include>


</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand">E-Electrical Billing</a>
        <form class="d-flex" action="SignInServlet" method="post">
            <input class="form-control me-2" type="email" placeholder="email"
                   aria-label="email" name="Semail" value="${Semail}">
            <input class="form-control me-2" type="password" placeholder="password"
                   aria-label="password" name="Spassword" value="${Spassword}">
            <button class="btn btn-outline-success" type="submit">Signin</button>
        </form>
    </div>
</nav>

    <jsp:include page="account.jsp"></jsp:include>

<footer>
    <jsp:include page="includes/foot.jsp"></jsp:include>
</footer>
</body>
</html>
