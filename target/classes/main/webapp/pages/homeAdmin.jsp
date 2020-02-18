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
    <script type="text/javascript" language="javascript">
        function visualizza(id){
            if (document.getElementById){
                if(document.getElementById(id).style.display == 'none'){
                    document.getElementById(id).style.display = 'block';
                }else{
                    document.getElementById(id).style.display = 'none';
                }
            }
        }
    </script>

    <%@include file="../header.jsp"%>
    <div class="col-lg-4"></div>
    <div class="col-lg-8">
    <table>

        <tr>
            <td>
                Nuovo utente : <button type="button" onclick="visualizza('nuovo'); return false" > Crea nuovo utente! </button>
            </td>
        </tr>
    </table>

        <div id="nuovo" style="display: none">
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
                        <input type="submit" name="crea" placeholder="crea" required="required">
                    </td>
                </tr>
                </table>
            </form>
        </div>
    <table>
    <%

        List <Utente> listaUtenti = (List<Utente>) request.getAttribute("utenti");
        for (Utente u : listaUtenti) {
            %>
            <tr>
                <td class="text-center"><%=u.getNome()%></td>
                <td class="text-center"><%=u.getCognome()%></td>
                <td class="text-center"><%=u.getEmail()%></td>
                <td class="text-center"><%=u.getRuolo().getDescrizione()%></td>
            </tr>
        <%
        }
    %>
    </table>

    </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</html>
