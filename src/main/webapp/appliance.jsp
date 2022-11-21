
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
            <h1 class="logo">Register your <span>appliance</span></h1>
            <p style="color:red; font-size: 15px">${acc_error}</p>
            <div class="formBody">
                <form action="ApplianceServlet" method="post">
                    <input name="aplName" type="text" placeholder="Appliance Name" value="${aplName}">
                    <input name="aplNumber" type="number" placeholder="number of appliance" value="${aplNumber}">
                    <input name="power" type="number" placeholder="Appliance Power in watts" value="${power}">
                    <input name="time" type="number" placeholder="time used per day(hrs)" value="${time}">
                    <button type="submit">Register</button>
               </form>
            </div>
        </div>
</div>

</body>
</html>
