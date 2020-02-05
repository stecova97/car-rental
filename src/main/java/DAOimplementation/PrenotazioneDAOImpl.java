package main.java.DAOimplementation;

import main.java.DAO.PrenotazioneDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Prenotazione;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();

    public void salvaPrenotazione(Prenotazione p) {
        Session session = this.sessionFactory.openSession();
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(p.getUtente());
        prenotazione.setVeicolo(p.getVeicolo());
        prenotazione.setData_fine(p.getData_inizio());
        prenotazione.setData_inizio(p.getData_fine());

        session.save(prenotazione);
        session.close();
    }




    @Override
    public List<Prenotazione> selezionaPrenotazioniPerUtente(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Prenotazione> prenotazioni = null;

        prenotazioni= (List<Prenotazione>) session.createQuery(
                "SELECT idPrenotazione, utente, veicolo FROM Prenotazione WHERE utente =  " + id
        ).list();

        session.close();
        return prenotazioni;
    }


    public void eliminaPrenotazione(Prenotazione p) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        Query q = session.createQuery("DELETE FROM Prenotazione  WHERE  idPrenotazione = " + p.getIdPrenotazione());

        session.getTransaction().commit();
        session.close();
    }


    public Prenotazione selezionaPrenotazione(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Prenotazione p = null;

        p = (Prenotazione) session.createQuery(
                "SELECT idPrenotazione, utente, veicolo FROM Prenotazione where idPrenotazione =  " +  id
        ).getSingleResult();

        return p;
    }

    private static PrenotazioneDAOImpl istanza = null;

    public static synchronized PrenotazioneDAOImpl getPrenotazioneDAOImpl() {
        if (istanza == null) {
            istanza = new PrenotazioneDAOImpl();
        }
        return istanza;
    }
}
