package main.java.Controller;

import main.java.DAOimplementation.CasaAutomobilisticaDAOImpl;
import main.java.DAOimplementation.RuoloDAOImpl;
import main.java.DAOimplementation.UtenteDAOImpl;
import main.java.DAOimplementation.VeicoloDAOImpl;
import main.java.DTO.UtenteDTO;
import main.java.entities.CasaAutomobilistica;
import main.java.entities.Ruolo;
import main.java.entities.Utente;
import main.java.entities.Veicolo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreaModificaVeicolo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;
        String c = req.getParameter("cancella");
        String n = req.getParameter ("nuovo");
        String m = req.getParameter ("update");
        Veicolo vtmp = null;
        boolean exist;

        if(c!=null)
            VeicoloDAOImpl.getVeicoloDAOImpl().eliminaVeicolo(c);
        else{
            //update o modifica
            Veicolo veicolo = new Veicolo();
            String s = req.getParameter("targa");
            if(n!=null) {                                       // se è nuovo ma esiste già
                exist=VeicoloDAOImpl.getVeicoloDAOImpl().veicoloExist(s);
                if (exist) {
                    req.setAttribute("VeicoloGiaRegistrato", true);
                    dispatcher= req.getRequestDispatcher("/parcoAuto");
                    dispatcher.forward(req,resp);
                }
            }
            veicolo.setTarga(s);                                        // sia update che create sono uguali tranne per l'id
            veicolo.setTipo(req.getParameter("tipo"));
            veicolo.setModello("modello");
            veicolo.setAnno_immatricolazione(Integer.valueOf(req.getParameter("anno")));
            CasaAutomobilistica casa = CasaAutomobilisticaDAOImpl.getCasaAutomobilisticaDAOImpl().trovaCasa(req.getParameter("casa"));
            veicolo.setCasa_automobilista(casa);
            if(n!=null)                                         //nuovo salvo così com'è
                VeicoloDAOImpl.getVeicoloDAOImpl().salvaVeicolo(veicolo);
            else
                VeicoloDAOImpl.getVeicoloDAOImpl().updateVeicolo(veicolo); //modifico-> update
            req.setAttribute("VeicoloGiaRegistrato", false);
        }
        dispatcher= req.getRequestDispatcher("/parcoAuto");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;
        String m = req.getParameter ("update");

        if(m!=null){
            Veicolo v = VeicoloDAOImpl.getVeicoloDAOImpl().selezioneVeicolo(m);
            req.setAttribute("veicolo",v);
            req.setAttribute("modifica", true);
        }else
            req.setAttribute("modifica", false);
        dispatcher= req.getRequestDispatcher("/pages/creaVeicolo.jsp");
        dispatcher.forward(req,resp);
    }
}
