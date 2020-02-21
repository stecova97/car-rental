<%@ page import ="main.java.DAOimplementation.UtenteDAOImpl" %>
<%@ page import ="java.util.List" %>
<%@ page import="main.java.entities.Utente" %>
<%@ page import="main.java.entities.Veicolo" %>
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
<div class="col-lg-9">
    <table>
        <tr>
            <td>
                <form>
                    <input type="text" onkeyup="ricerca()" id="cerca" placeholder="Ricerca"> </i><i class="fa fa-search fa-lg"></i>

                    <select id="filtro" required="required">
                        <option value="targa">Targa</option>
                        <option value="tipo">Tipo</option>
                        <option value="modello">modello</option>
                        <option value="casa">Casa Automobilistica</option>
                    </select>
                </form>
            </td>
        </tr>
    </table>

    <form action="creaModificaVeicolo" method="get">
        <div>Nuovo veicolo : <button type="submit" name="nuovo" > Inserisci un nuovo veicolo! </button> </div>
    </form>
    <%
        List <Veicolo> listaVeicoli = (List<Veicolo>) request.getAttribute("veicoli");
        for (Veicolo v : listaVeicoli) {
    %>

    <table id="veicoli">
        <tr id="v">
            <td id="targa" class="text-center"><%=v.getTarga()%></td>
            <td id="tipo" class="text-center"><%=v.getTipo()%></td>
            <td id="modello" class="text-center"><%=v.getModello()%></td>
            <td id="casa" class="text-center"><%=v.getCasa_automobilista().getNome()%></td>

            <td>
                <form action="creaModificaVeicolo" method="post">
                    <button type="submit" name="cancella" value="<%= v.getTarga() %>" >Cancella</button>

                </form>

                <form action="creaModificaVeicolo" method="get">
                    <button type="submit" name="update" value="<%= v.getTarga() %>" >Modifica</button>
                </form>


            </td>
        </tr>
        <%
            }
        %>
    </table>

</div>
<div class="col-lg-3"></div>

<script>
    function ricerca(){
        //prendo i campi per cui filtrare
        var filter = document.getElementById("filtro");
        var f = filter.options[filter.selectedIndex].value;     //si prende il campo da filtrare es. nome email o altro

        var h;
        if(f == "targa")
            h=0;
        if(f == "tipo")
            h=1;
        if(f == "modello")
            h=2;
        if(f == "casa")
            h=3;


        var table = document.getElementById("veicoli");
        var tsize =document.getElementById("veicoli").rows.length;

        var input = document.getElementById("cerca").value;
        input =input.toUpperCase();
        var riga = table.getElementsByTagName("tr");


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
