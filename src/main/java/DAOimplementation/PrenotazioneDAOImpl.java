package main.java.DAOimplementation;

import main.java.DAO.PrenotazioneDAO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Prenotazione;
import main.java.entities.Utente;
import main.java.entities.Veicolo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDAOImpl implements PrenotazioneDAO {

//    private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();

    public void salvaPrenotazione(Prenotazione p) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }




    @Override
    public List<Prenotazione> selezionaPrenotazioniPerUtente(Integer id) {
        List<Prenotazione> prenotazioni = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try  {
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            prenotazioni = session.createQuery("select p from Prenotazione p inner join Utente u on p.utente.idUtente = u.idUtente where u.idUtente =: id", Prenotazione.class).setParameter("id",id).getResultList();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return prenotazioni;
    }


    public void eliminaPrenotazione(Prenotazione p) {
        Session session;
        session= javaHibernateUtil.getHibernateSession();
        session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Prenotazione pe WHERE pe.idPrenotazione ='" + p.getIdPrenotazione() + "'");
        try {
            q.executeUpdate();
            session.getTransaction().commit();
        }catch (PersistenceException pe){
            throw pe;
        }finally{
            session.close();
        }
    }


    public Prenotazione selezionaPrenotazione(int id) {
        Prenotazione p = new Prenotazione();
        Transaction transaction = null;
        Session session = null;
        try{
            session= javaHibernateUtil.getHibernateSession();
            p = (Prenotazione) session.createQuery("select pe from Prenotazione pe where pe.idPrenotazione like ="+ id  ).getSingleResult();
        }
        catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            p=null;
        }
        finally {
                session.close();
        }
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
