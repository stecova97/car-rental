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
        RequestDispatcher dispatcher;
        String c = req.getParameter("cancella");
        String n = req.getParameter ("nuovo");
        String m = req.getParameter ("update");
        Utente utmp = null;
        boolean exist;

        if(c!=null){
            int id = Integer.valueOf(c);
            UtenteDAOImpl.getUtentiDAO().eliminaUtente(id);
            //req.setAttribute("cancella", null);
        }else{
            //update o modifica
            Utente user = new Utente();
            UtenteDTO u = new UtenteDTO();
            String s = req.getParameter("email");
            if(n!=null) {                                       // se è nuovo ma esiste già
                exist=UtenteDAOImpl.getUtentiDAO().utenteExist(s);
                if (exist) {
                    req.setAttribute("UtenteGiaRegistrato", true);
                    dispatcher= req.getRequestDispatcher("/home");
                    dispatcher.forward(req,resp);
                }
            }/*else{
                utmp =UtenteDAOImpl.getUtentiDAO().trovaUtente(s);       //recupero id
            }*/
            user.setNome(req.getParameter("nome"));         // sia update che create sono uguali tranne per l'id
            user.setCognome(req.getParameter("cognome"));
            user.setEmail(s);
            user.setPassword(req.getParameter("password"));
            Ruolo r = RuoloDAOImpl.getRuoloDAOImpl().trovaRuolo(req.getParameter("ruolo"));
            user.setRuolo(r);
            if(n!=null)                                         //nuovo salvo così com'è
                UtenteDAOImpl.getUtentiDAO().salvaUtente(user);
            else{
                /*user.setIdUtente(utmp.getIdUtente);*/
                String email = (String) session.getAttribute("user");
                utmp = UtenteDAOImpl.getUtentiDAO().trovaUtente(email);
                user.setIdUtente( utmp.getIdUtente() );
                UtenteDAOImpl.getUtentiDAO().updateUtente(user); //modifico-> update
            }

            req.setAttribute("UtenteGiaRegistrato", false);
            req.setAttribute("email", s);

        }
        dispatcher= req.getRequestDispatcher("/home");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;
        String m = req.getParameter ("update");

        if(m!=null){
            int id = Integer.valueOf(m);
            Utente u = UtenteDAOImpl.getUtentiDAO().trovaUtente(id);
            req.setAttribute("utente",u);
            req.setAttribute("modifica", true);
        }else
            req.setAttribute("modifica", false);
        dispatcher= req.getRequestDispatcher("/pages/creaUtente.jsp");
        dispatcher.forward(req,resp);
    }
}
