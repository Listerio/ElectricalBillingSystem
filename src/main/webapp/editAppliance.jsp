
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
        <p style="color:red; font-size: 15px">${Eacc_error}</p>
        <div class="formBody">
            <form action="editApp" method="post">
                <input name="EaplName" type="text" placeholder="Appliance Name" value="${EaplName}">
                <p style="color: whitesmoke">Fill in only changed properties</p>
                <input name="EaplNumber" type="number" placeholder="Number of appliance" value="${EaplNumber}">
                <input name="Epower" type="number" placeholder="Appliance Power in watts" value="${Epower}">
                <input name="Etime" type="number" placeholder="Time used per day(hrs)" value="${Etime}">
                <button type="submit">Confirm</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
