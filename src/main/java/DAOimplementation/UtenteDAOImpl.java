package main.java.DAOimplementation;

import main.java.DAO.UtenteDAO;
import main.java.DTO.UtenteDTO;
import main.java.HibernateUtil.javaHibernateUtil;
import main.java.entities.Utente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {
    //private SessionFactory sessionFactory = javaHibernateUtil.getSessionFactory();


    public Utente loginUtente(UtenteDTO utenteDTO) {
        Utente utente;
        Transaction transaction = null;
        Session session = null;
        try {
            session = javaHibernateUtil.getHibernateSession();
            transaction = session.beginTransaction();
            utente = session.createQuery("FROM Utente U WHERE U.email=:email and U.password=:password", Utente.class)
                    .setParameter("email", utenteDTO.getEmail())
                    .setParameter("password", utenteDTO.getPsw())
                    .getSingleResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            utente = null;
            //e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        javaHibernateUtil.shutdown();
        return utente;
    }

    @Override
   public void eliminaUtente(int id) {
        Transaction transaction = null;
        Session session = null;
        session = javaHibernateUtil.getHibernateSession();
        transaction = session.beginTransaction();

        Query q = session.createQuery("delete from Utente where idUtente = " + id);
        q.executeUpdate();

        session.close();
        javaHibernateUtil.shutdown();


    }
//
//    @Override
    public void updateUtente(Utente u) {
        Transaction transaction = null;
        Session session = null;
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        session.update(u);
//        session.getTransaction().commit();
//        session.close();
    }

    @Override
    public void salvaUtente(Utente u) {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Utente utente = new Utente();
//        utente.setCognome(u.getCognome());
//        utente.setEmail(u.getEmail());
//        utente.setIdUtente(u.getIdUtente());
//        utente.setNome(u.getNome());
//        utente.setPassword(u.getPassword());
//        utente.setRuolo(u.getRuolo());
//        session.save(utente);
//        session.close();
    }
//
    @Override
    public List<Utente> selezionaUtenti() {
        List<Utente> utenti = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = javaHibernateUtil.getHibernateSession()) {
            utenti = session.createQuery("from Utente", Utente.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return utenti;
    }
//
    @Override
    public Utente trovaUtente(String email) {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Utente u = null;
//
//        u = (Utente) session.createQuery(
//                "SELECT * FROM Utente WHERE email =" + email
//        ).getSingleResult();
//        session.getTransaction().commit();
//        session.close();
//        return u;
//
        return null;
    }

    private static UtenteDAOImpl istanza = null;

    private UtenteDAOImpl() {
    }

    //accesso al singleton
    public static synchronized UtenteDAOImpl getUtentiDAO() {
        if (istanza == null) {
            istanza = new UtenteDAOImpl();
        }
        return istanza;
    }

}
