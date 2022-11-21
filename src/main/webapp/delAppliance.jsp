
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="styles/welcome.css" >
    <link rel="stylesheet" href="styles/bigCover.css">
</head>
<body>
<div class="Bigcover">
    <jsp:include page="includes/navbar.jsp"></jsp:include>
    <div class="regisAppl">
        <h1 class="logo">Enter your Appliance Name: </h1>
        <p style="color:red; font-size: 15px">${Dacc_error}</p>
        <div class="formBody">
            <form action="delApp" method="post">
                <input name="DaplName" type="text" placeholder="Appliance Name" value="${DaplName}">
                <button type="submit">Confirm</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
