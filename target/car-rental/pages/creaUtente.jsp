<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Stefano
  Date: 20/02/2020
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="main.java.entities.Utente" %>
<html>
<head>
    <title>Crea o Modifica Utente</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%
    boolean modifica = (boolean) request.getAttribute("modifica");

%>
<c:set var = "modifica" scope = "session" value ="<%=modifica%>"/>
<c:choose>
    <c:when test="${modifica == false}">
        <form action="creaModificaUtente" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" name="nome" placeholder="nome" required="required">
                    </td>
                    <td>
                        <input type="text" name="cognome" placeholder="cognome" required="required">
                    </td>
                    <td>
                        <input type="text" name="email" placeholder="email" required="required">
                    </td>
                    <td>
                        <input type="password" name="password" placeholder="password" required="required">
                    </td>
                    <td>
                        <select name="ruolo" required="required">
                            <option value="SuperUser">SuperUser</option>
                            <option value="Customer">Customer</option>
                        </select>
                    </td>
                    <td>
                        <input type="submit" name="nuovo" placeholder="crea" required="required">
                    </td>
                </tr>
            </table>
        </form>
    </c:when>

    <c:when test="${modifica == true}">
        <%
            Utente u = (Utente) request.getAttribute("utente");
        %>
        <form action="creaModificaUtente" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" name="nome" value="<%=u.getNome()%>" required="required">
                    </td>
                    <td>
                        <input type="text" name="cognome" value="<%=u.getCognome()%>" required="required">
                    </td>
                    <td>
                        <input type="text" name="email" value="<%=u.getPassword()%>" required="required">
                    </td>
                    <td>
                        <input type="password" name="password" placeholder="password" required="required">
                    </td>
                    <td>
                        <c:choose>
                         <c:when test ="${sessionScope.isSuperUser ==true}">
                            <select name="ruolo" required="required">
                                <option value="SuperUser">SuperUser</option>
                                <option value="Customer">Customer</option>
                            </select>
                        </c:when>
                            <c:when test ="${sessionScope.isSuperUser ==false}">
                            </c:when>
                        </c:choose>
                    </td>
                    <td>
                        <input type="submit" name="modifica" placeholder="crea" required="required">
                    </td>

                </tr>
            </table>
        </form>

    </c:when>
</c:choose>

</body>
</html>
