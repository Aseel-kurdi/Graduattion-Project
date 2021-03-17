
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Admin page</title>
    <link rel="icon" type="image/png" href="https://i.ibb.co/xGXRwLF/130822812-836734607102721-7712471177251957862-n.png" />
    <meta charset="utf-8" />
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Castoro&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <nav>
        <a href="Home" >Home</a>
        <a href="AboutUs" >About Us</a>
    </nav>
</header>


<table>
    <tr>

        <th>PharmacyName</th>
        <th>pharmacyID</th>
        <th>Approve</th>
        <th>Reject</th>
    </tr>

    <c:forEach items="${requestScope.information}" var="val">
            <tr>
                <td>${val.pharmacyName }</td>
                <td>${val.pharmacyID}</td>
                <td>
                    <form action="ApprovalPage" method="post">
                        <input type="hidden" name="status" value="accepted">
                        <input type="hidden" name="id" value="${val.pharmacyID}">
                        <input class = "adminsubmit" type="submit" value="Approve"  >
                    </form>
                </td>
                <td>
                    <form action="ApprovalPage" method="post">
                        <input type="hidden" name="status" value="rejected">
                        <input type="hidden" name="id" value="${val.pharmacyID}">
                        <input class = "adminsubmit" type="submit" value="Reject"  >
                    </form>
                </td>
            </tr>

    </c:forEach>
</table>


</body>
</html>
