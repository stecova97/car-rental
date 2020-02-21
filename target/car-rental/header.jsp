<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Stefano
  Date: 11/02/2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%--    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">--%>
</head>
<body>
<%
    int ut = (int) session.getAttribute("ut");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${sessionScope.isSuperUser == true}">
                    <li class="nav-item active">
                        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:when test="${sessionScope.isSuperUser == false}">
                    <li class="nav-item active">
                        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
            </c:choose>

            <li class="nav-item">
                <a class="nav-link" name="parco" href="/parcoAuto">Parco Auto</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" name="update" href="${pageContext.request.contextPath}/creaModificaUtente?update=<%=ut%>">Profilo</a>
            </li>
        </ul>
        </div>
    </div>
    <div class="col-lg-2"></div>
    <div class="col-lg-2">
        <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/logout">Log Out</a>
        </li>
        </ul>
    </div>
</nav>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</html>
