<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        <h1 class="logo">Bill<span>Information</span></h1>
        <p style="color:red; font-size: 15px">${e1rror}</p>
        <div class="formBody">
            <form action="pay" method="post">
                <label for="1">Card Number: </label>
                <input id="1" name="cNumber" type="number" value="${cNumber}">
                <label for="2">Exp Date: </label>
                <input id="2" name="eDate" type=date value="${eDate}">
                <label for="4">Cvv: </label>
                <input id="4" name="cV" type="number"  value="${cV}" >
                <button type="submit">Pay-Now</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
