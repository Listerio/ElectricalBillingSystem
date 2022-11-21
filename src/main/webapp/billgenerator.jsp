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
        <div class="formBody">
            <form action="bill" method="post">
                <label for="1">Maintenance Fee: </label>
                <input id="1" name="maintain" type="text" value="$ ${maintain}" readonly>
                <label for="2">Fixed Charge: </label>
                <input id="2" name="fixed" type="text" value="$ ${fixed}" readonly>
                <label for="3">Unit Charge: </label>
                <input id="3" name="uCharge" type="text" value="$ ${uCharge}" readonly>
                <label for="4">Grand Total:</label>
                <input id="4" name="gTotal" type="text"  value="$ ${gTotal}" readonly>
                <button type="submit">Pay Now</button>
            </form>
        </div>
     </div>
 </div>

</body>
</html>
