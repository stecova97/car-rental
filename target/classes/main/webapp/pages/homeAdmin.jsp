<%@ page import ="main.java.DAOimplementation.UtenteDAOImpl" %>
<%@ page import ="java.util.List" %>
<%@ page import="main.java.entities.Utente" %>
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
        List <Utente> listaUtenti = (List<Utente>) request.getAttribute("utenti");
        for (Utente u : listaUtenti) {
            %>
            <tr>
                <td class="text-center"><%=u.getNome()%></td>
                <td class="text-center"><%=u.getCognome()%></td>
            </tr>
        <%
        }
    %>
    </table>


    </body>
</html>
