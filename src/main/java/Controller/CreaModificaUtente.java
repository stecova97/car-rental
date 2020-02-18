package main.java.Controller;

import main.java.DAOimplementation.RuoloDAOImpl;
import main.java.DAOimplementation.UtenteDAOImpl;
import main.java.DTO.UtenteDTO;
import main.java.entities.Ruolo;
import main.java.entities.Utente;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreaModificaUtente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente user = new Utente();
        RequestDispatcher dispatcher;
        UtenteDTO u= new UtenteDTO();
        //TODO inserisco try catch per verificare se esiste già l'utente
        String s= req.getParameter("email");

        if(!UtenteDAOImpl.getUtentiDAO().utenteExist(s)){
            user.setNome(req.getParameter("nome"));
            user.setCognome(req.getParameter("cognome"));
            user.setEmail(s);
            user.setPassword(req.getParameter("password"));
            Ruolo r = RuoloDAOImpl.getRuoloDAOImpl().trovaRuolo(req.getParameter("ruolo"));
            user.setRuolo(r);
            UtenteDAOImpl.getUtentiDAO().salvaUtente(user);
            req.setAttribute("UtenteGiaRegistrato", false);
            req.setAttribute("email",s);

        }else{
            req.setAttribute("UtenteGiaRegistrato", true);
           // dispatcher= req.getRequestDispatcher("/pages/homeAdmin.jsp");
        }
        dispatcher= req.getRequestDispatcher("/home");
        dispatcher.forward(req,resp);

    }
}
