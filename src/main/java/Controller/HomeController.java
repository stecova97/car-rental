package main.java.Controller;

import main.java.DAOimplementation.PrenotazioneDAOImpl;
import main.java.DAOimplementation.UtenteDAOImpl;
import main.java.DTO.UtenteDTO;
import main.java.entities.Prenotazione;
import main.java.entities.Utente;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente userlog;
        UtenteDTO user;
        user = new UtenteDTO();
        RequestDispatcher dispatcher;

        String emailUserLog = (String) session.getAttribute("user");
        if(emailUserLog == null) {       //user non loggato
            String email = (String) req.getAttribute("email");
            String password = (String) req.getAttribute("psw");
            user.setEmail(email);
            user.setPsw(password);
            userlog = UtenteDAOImpl.getUtentiDAO().loginUtente(user);
        }else{
            userlog = UtenteDAOImpl.getUtentiDAO().trovaUtente(emailUserLog);
        }

        //controllo se è super user -> visulizzo cose piuttosto che altre

        if(userlog == null){                        //user non registrato
            dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req,resp);
        }else if(userlog.getRuolo().getIdRuolo() == 1 ) {
            session.setAttribute("user", userlog.getEmail());                               //user registrato super
            List<Utente> utenti = UtenteDAOImpl.getUtentiDAO().selezionaUtenti();
            dispatcher =req.getRequestDispatcher("/pages/homeAdmin.jsp");
        }else{
            session.setAttribute("user", userlog.getEmail());                               //user registrato customer
            List<Prenotazione> prenotazioni = PrenotazioneDAOImpl.getPrenotazioneDAOImpl().selezionaPrenotazioniPerUtente(userlog.getIdUtente());
            dispatcher =req.getRequestDispatcher("/pages/homeCustomer.jsp");
        }
            dispatcher.forward(req,resp);



    }
}
