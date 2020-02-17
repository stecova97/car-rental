<%@ page import ="main.java.DAOimplementation.UtenteDAOImpl" %>
<%@ page import ="java.util.List" %>
<%@ page import="main.java.entities.Prenotazione" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Home admin
    </title>
</head>
<body>
<%@include file="../header.jsp"%>
<table>
    <%
        List <Prenotazione> listaPrenotazioni = (List<Prenotazione>) request.getAttribute("prenotazioni");
        for (Prenotazione p : listaPrenotazioni) {
    %>
    <tr>
        <td class="text-center"><%=p.getIdPrenotazione()%></td>
        <td class="text-center"><%=p.getData_inizio()%></td>
        <td class="text-center"><%=p.getData_fine()%></td>
        <td class="text-center"><%=p.getUtente().getNome()%></td>
        <td class="text-center"><%=p.getVeicolo().getModello()
        %></td>
    </tr>
    <%
        }
    %>
</table>


</body>
</html>
