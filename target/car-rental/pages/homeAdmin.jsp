<%@ page import ="main.java.DAOimplementation.UtenteDAOImpl" %>
<%@ page import ="java.util.List" %>
<%@ page import="main.java.entities.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="../css/font-awesome-4.7.0/css/font-awesome.min.css">
        <title>
            Home admin
        </title>
    </head>
    <body>

    <%@include file="../header.jsp"%>
    <div class="col-lg-3"></div>
    <div class="col-lg-9">
    <table>
        <tr>
            <td>
<%--                Nuovo utente : <button type="button" return false" > Crea nuovo utente! </button>--%>
            </td>
        </tr>
        <tr>
            <td>
                <form>
                    <input type="text" onkeyup="ricerca()" id="cerca" placeholder="Ricerca"> </i><i class="fa fa-search fa-lg"></i>

                    <select id="filtro" required="required">
                        <option value="nome">Nome</option>
                        <option value="cognnome">Cognome</option>
                        <option value="email">Email</option>
                        <option value="ruolo">Ruolo</option>
                    </select>
                </form>
            </td>
        </tr>
    </table>

<%--        <div id="nuovo" style="display: none">--%>
<%--            <form action="creaModificaUtente" method="post">--%>
<%--                <table>--%>
<%--                <tr>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="nome" placeholder="nome" required="required">--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="cognome" placeholder="cognome" required="required">--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="email" placeholder="email" required="required">--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <input type="password" name="password" placeholder="password" required="required">--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <select name="ruolo" required="required">--%>
<%--                            <option value="SuperUser">SuperUser</option>--%>
<%--                            <option value="Customer">Customer</option>--%>
<%--                        </select>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <input type="submit" name="crea" placeholder="crea" required="required">--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                </table>--%>
<%--            </form>--%>
<%--        </div>--%>
        <form action="creaModificaUtente" method="get">
            <div>Nuovo utente : <button type="submit" name="nuovo" href="creaModificaUtente" > Crea nuovo utente! </button> </div>
        </form>


    <table id="utenti">
    <%
        List <Utente> listaUtenti = (List<Utente>) request.getAttribute("utenti");
        for (Utente u : listaUtenti) {
            int i=0;
            %>
            <tr id="u" value="<%= i %>">
                <td id="nome" class="text-center"><%=u.getNome()%></td>
                <td id="cognome" class="text-center"><%=u.getCognome()%></td>
                <td id="email" class="text-center"><%=u.getEmail()%></td>
                <td id="descrizione" class="text-center"><%=u.getRuolo().getDescrizione()%></td>

                <td>
                    <form action="creaModificaUtente" method="post">
                        <button type="submit" name="cancella" value="<%= u.getIdUtente() %>" >Cancella</button>

                    </form>

                    <form action="creaModificaUtente" method="get">
                        <button type="submit" name="update" value="<%= u.getIdUtente() %>" >Modifica</button>
                    </form>


                </td>
            </tr>
        <%
        }
    %>
    </table>

    </div>

    <script>
        function visualizza(id){
            if (document.getElementById){
                if(document.getElementById(id).style.display == 'none'){
                    document.getElementById(id).style.display = 'block';
                }else{
                    document.getElementById(id).style.display = 'none';
                }
            }
        }

        function ricerca(){
            //prendo i campi per cui filtrare
            var filter = document.getElementById("filtro");
            var f = filter.options[filter.selectedIndex].value;     //si prende il campo da filtrare es. nome email o altro

            var h;
            if(f == "nome")
                h=0;
            if(f == "cognome")
                h=1;
            if(f == "email")
                h=2;
            if(f == "ruolo")
                h=3;


            var table = document.getElementById("utenti");
            var tsize =document.getElementById("utenti").rows.length;
            /*
            table.row[].cell[]
            table.rows[0].item(0).innerHTML = utente 1
            */
            // var searchLenght = document.getElementById(search).length;
            var input = document.getElementById("cerca").value;
            input =input.toUpperCase();
            var riga = table.getElementsByTagName("tr");

            console.log(input);
            var j=0;
             for(i=0; i<tsize; i++){

                 if(table.rows[i].cells.item(h).innerHTML.toUpperCase().indexOf(input) !== -1)
                     riga[i].style.display= "";
                 else
                     riga[i].style.display ="none";
             }
        }

    </script>

    </body>
<%--    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>
</html>
