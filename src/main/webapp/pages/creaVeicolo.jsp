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
<%@ page import="main.java.entities.Veicolo" %>
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
        <form action="creaModificaVeicolo" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" name="targa" placeholder="targa" required="required">
                    </td>
                    <td>
                        <input type="text" name="tipo" placeholder="tipo" required="required">
                    </td>
                    <td>
                        <input type="text" name="modello" placeholder="modello" required="required">
                    </td>
                    <td>
                        <input type="text" name="anno" placeholder="anno immatricolazione" required="required">
                    </td>
                    <td>
                        <input type="text" name="casa" placeholder="Casa automobilistica" required="required">
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
            Veicolo v = (Veicolo) request.getAttribute("veicolo");
        %>
        <form action="creaModificaVeicolo" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" name="targa" value="<%=v.getTarga()%>" required="required">
                    </td>
                    <td>
                        <input type="text" name="tipo" value="<%=v.getTipo()%>" required="required">
                    </td>
                    <td>
                        <input type="text" name="modello" value="<%=v.getModello()%>" required="required">
                    </td>
                    <td>
                        <input type="password" name="anno" value="<%=v.getAnno_immatricolazione()%>" required="required">
                    </td>
                    <td>
                        <input type="password" name="anno" value="<%=v.getCasa_automobilista()%>" required="required">
                    </td>

                    <td>
                        <input type="submit" name="modifica" placeholder="modifica" required="required">
                    </td>

                </tr>
            </table>
        </form>

    </c:when>
</c:choose>

</body>
</html>
