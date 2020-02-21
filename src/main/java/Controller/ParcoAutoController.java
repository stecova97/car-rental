package main.java.Controller;

import main.java.DAOimplementation.VeicoloDAOImpl;
import main.java.entities.Veicolo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ParcoAutoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Veicolo> veicoloList  =VeicoloDAOImpl.getVeicoloDAOImpl().elencoVeicoli();
        req.setAttribute("veicoli",veicoloList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/parcoAutoPage.jsp");
        dispatcher.forward(req,resp);
    }
}
